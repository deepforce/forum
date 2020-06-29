package deepforce.forum.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND(2001, "Question doesn't exist."),
    TARGET_PARENT_NOT_FOUND(2002, "No questions or comments were selected."),
    NO_LOGIN(2003, "You can't operate without logging in. Please log in first."),
    SYS_ERROR(2004, "Server Error!"),
    TYPE_PARAM_WRONG(2005, "Wrong comment type or type not exist."),
    COMMENT_NOT_FOUND(2006, "The comment you reply doesn't exist"),
    CONTENT_IS_EMPTY(2007, "The input value cannot be empty."),
    ;

    CustomizeErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }


}
