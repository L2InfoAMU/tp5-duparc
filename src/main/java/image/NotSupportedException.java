package image;

public class NotSupportedException extends RuntimeException {
    public NotSupportedException(String error){
        throw new RuntimeException(error);
    }
}
