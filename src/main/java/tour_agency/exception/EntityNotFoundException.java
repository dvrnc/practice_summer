package tour_agency.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException (String message) {
        super(message);
    }
}
