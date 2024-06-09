package tr.com.sample.common.security.model.request;

import jakarta.validation.constraints.NotBlank;
import tr.com.sample.common.base.IBaseDTO;

/**
 * @author arif.erol
 */
public class LoginRequest implements IBaseDTO {
    private static final long serialVersionUID = 1L;
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
