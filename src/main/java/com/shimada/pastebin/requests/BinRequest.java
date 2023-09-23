package com.shimada.pastebin.requests;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class BinRequest {

    private Long userId;
    private String text;
}
