package com.shimada.pastebin.requests;

import com.shimada.pastebin.entity.Bin;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class BinRequest {

    private Long userId;
    private String text;
}
