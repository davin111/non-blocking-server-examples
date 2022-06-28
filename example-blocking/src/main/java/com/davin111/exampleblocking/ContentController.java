package com.davin111.exampleblocking;

import com.davin111.exampleblocking.dto.ContentsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;

    @GetMapping("/v1/contents/free")
    public ContentsDto getContentsFree() {
        return contentService.getContentsFree();
    }

    @GetMapping("/v1/contents/premium")
    public ContentsDto getContentsPremium() {
        Long userId = 0L;
        return contentService.getContentsPremium(userId);
    }
}
