package com.piyush.smartResearchAssistent.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.piyush.smartResearchAssistent.entity.GeminiResponse;
import com.piyush.smartResearchAssistent.entity.ResearchRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service

public class ResearchService {
    @Value("${gemini.api.url}")
    private String geminiApiUrl;

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    public ResearchService(WebClient.Builder webClientBuilder, ObjectMapper objectMapper) {
        this.webClient = webClientBuilder.build();
        this.objectMapper = objectMapper;
    }

    public String processContent(ResearchRequest request) {
        // build the prompt

        String prompt = buildPrompt(request);
        // Query the api Model Api

        Map<String , Object> requestbody = Map.of(
                "contents" ,new Object[]{
                        Map.of("parts" , new Object[]{
                                Map.of("text" , prompt)
                        })
                }
        );


        String response = webClient.post()
                .uri(geminiApiUrl + geminiApiKey)
                .bodyValue(requestbody)
                .retrieve()
                .bodyToMono(String.class)
                .block();


        // Parse the response
        // Return response

        return extractTextFromResponse(response);
    }

    private String extractTextFromResponse(String response) {
        try {
            GeminiResponse geminiResponse = objectMapper.readValue(response , GeminiResponse.class);

            if(geminiResponse.getCandidates() != null && !geminiResponse.getCandidates().isEmpty()){
                GeminiResponse.Candidate firstCandidate = geminiResponse.getCandidates().get(0);

                if(firstCandidate.getContent() != null &&
                      firstCandidate.getContent().getParts() != null &&
                       !firstCandidate.getContent().getParts().isEmpty()){
                    return firstCandidate.getContent().getParts().get(0).getText();
                }
            }

            return "No content is found";
        }catch (Exception e){
            return "Error Parsing: "+ e.getMessage();
        }
    }

    private String buildPrompt(ResearchRequest request){
        StringBuilder prompt = new StringBuilder();

        switch (request.getOperation()){
            case "paragraph":
                prompt.append("Provide a clear and concise summary of the following text in a few sentences: \n\n");
                break;

            case "bullet" :
                prompt.append("Provide a clear and concise summary of the following text in a 4 to 5 bullet point: \n\n");
                break;

            case "generateQuestions":
                prompt.append("Read the following content and generate 5 interview-style questions that test understanding of the material. Include both conceptual and application-based questions:\n\n");
                break;

            case "explainLike5":
                prompt.append("Explain the following content in very simple language, as if you are teaching a 5-year-old. Avoid jargon and make it easy to understand with examples if needed:\n\n");
                break;

            case "paraphrase":
                prompt.append("Paraphrase the following text in a clearer, simpler, and more professional way without changing its meaning:\n\n");
                break;

            default:
                throw new IllegalArgumentException("Unknown Operation: " + request.getOperation());
        }
        prompt.append(request.getContent());
        return prompt.toString();
    }
}
