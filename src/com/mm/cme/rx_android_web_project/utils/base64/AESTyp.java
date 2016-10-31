package com.mm.cme.rx_android_web_project.utils.base64;
public enum AESTyp {

	ECB("ECB", "0"), CBC("CBC", "1"), CFB("CFB", "2"), OFB("OFB", "3");
	private String k;
	private String v;

	private AESTyp(String k, String v) {
		this.k = k;
		this.v = v;
	}

	public String key() {
		return this.k;
	}

	public String value() {
		return this.v;
	}

	public static AESTyp get(int id) {
		AESTyp[] vs = AESTyp.values();
		for (int i = 0; i < vs.length; i++) {
			AESTyp d = vs[i];
			if (d.key().equals(id))
				return d;
		}
		return AESTyp.CBC;
	}

}
