package tour_agency.DTO;

import java.time.LocalDate;

public class TourDTO {
    private Long id;
    private String direction;
    private Integer cost;
    private LocalDate startDate;
    private LocalDate finishDate;

    public TourDTO(Long id, String direction, Integer cost, LocalDate startDate, LocalDate finishDate) {
        this.id = id;
        this.direction = direction;
        this.cost = cost;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public TourDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }
}
