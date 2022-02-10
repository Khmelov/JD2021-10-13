package by.it.shcharbunou.calc.log;

import java.time.LocalDateTime;
import java.util.List;

public class Report {
    private String header;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<String> operationsAndResults;

    public static class Builder {
        private Report report;

        public Builder() {
            report = new Report();
        }

        public Builder withHeader(String header) {
            report.header = header;
            return this;
        }

        public Builder withStartTime(LocalDateTime startTime) {
            report.startTime = startTime;
            return this;
        }

        public Builder withEndTime(LocalDateTime endTime) {
            report.endTime = endTime;
            return this;
        }

        public Builder withOperationsAndResults(List<String> operationsAndResults) {
            report.operationsAndResults = operationsAndResults;
            return this;
        }

        public Report build() {
            return report;
        }
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public List<String> getOperationsAndResults() {
        return operationsAndResults;
    }

    public void setOperationsAndResults(List<String> operationsAndResults) {
        this.operationsAndResults = operationsAndResults;
    }

    @Override
    public String toString() {
        return "Report{\n" +
                "header='" + header + '\'' +
                "\n, startTime=" + startTime +
                "\n, endTime=" + endTime +
                "\n, operationsAndResults=\n" + operationsAndResults +
                '}';
    }
}
