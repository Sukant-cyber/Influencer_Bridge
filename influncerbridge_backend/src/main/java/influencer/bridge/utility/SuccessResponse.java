package influencer.bridge.utility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessResponse {

    private int statusCode;

    private String message;

    public SuccessResponse(final int statusCode, final String message){
        this.statusCode = statusCode;
        this.message = message;
    }
}
