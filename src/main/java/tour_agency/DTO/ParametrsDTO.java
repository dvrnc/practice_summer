package tour_agency.DTO;

import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public class ParametrsDTO {
   private String direction;
    private Integer costLow;
    private Integer costHigh;
    private Integer numberSeatsLow;
    private Integer numberSeatsHigh;
    private LocalDate startDate;
    private LocalDate finishDate;
    public ParametrsDTO() {
    }

    public ParametrsDTO(String direction, Integer costLow, Integer costHigh, Integer numberSeatsLow, Integer numberSeatsHigh, LocalDate startDate, LocalDate finishDate) {
        this.direction = direction;
        this.costLow = costLow;
        this.costHigh = costHigh;
        this.numberSeatsLow = numberSeatsLow;
        this.numberSeatsHigh = numberSeatsHigh;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getCostLow() {
        return costLow;
    }

    public void setCostLow(Integer costLow) {
        this.costLow = costLow;
    }

    public Integer getCostHigh() {
        return costHigh;
    }

    public void setCostHigh(Integer costHigh) {
        this.costHigh = costHigh;
    }

    public Integer getNumberSeatsLow() {
        return numberSeatsLow;
    }

    public void setNumberSeatsLow(Integer numberSeatsLow) {
        this.numberSeatsLow = numberSeatsLow;
    }

    public Integer getNumberSeatsHigh() {
        return numberSeatsHigh;
    }

    public void setNumberSeatsHigh(Integer numberSeatsHigh) {
        this.numberSeatsHigh = numberSeatsHigh;
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
