package com.davin111.examplenonblocking;

import com.davin111.examplenonblocking.dto.ContentsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;

    @GetMapping("/v1/contents/free")
    public Mono<ContentsDto> getContentsFree() {
        return contentService.getContentsFree();
    }

    @GetMapping("/v1/contents/premium")
    public Mono<ContentsDto> getContentsPremium() {
        Long userId = 0L;
        return contentService.getContentsPremium(userId);
    }
}
