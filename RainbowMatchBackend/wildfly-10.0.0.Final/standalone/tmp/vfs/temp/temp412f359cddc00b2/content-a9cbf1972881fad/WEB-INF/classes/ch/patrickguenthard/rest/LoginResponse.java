package ch.patrickguenthard.rest;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
	private String responseMessage;
	private Long userId;
}
