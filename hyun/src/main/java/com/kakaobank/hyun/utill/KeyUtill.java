package com.kakaobank.hyun.utill;

import java.util.UUID;

public class KeyUtill {
	public String makeGUID() {
		UUID uuid = UUID.randomUUID();
		String guid = uuid.toString()
						.replaceAll("[^a-zA-Z0-9]", "")
						.substring(0,30);
		return guid;
	}
}
