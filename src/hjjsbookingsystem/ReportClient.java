
package hjjsbookingsystem;

public class ReportClient {
    
    private ReportCommand reportCommand;

    public void setReportCommand(ReportCommand reportCommand) {
        this.reportCommand = reportCommand;
    }

    public void processReport(String choice) {
        if (choice.equalsIgnoreCase("1")) {
            setReportCommand(new LearnerReport());
        } else if (choice.equalsIgnoreCase("2")) {
            setReportCommand(new CoachReport());
        }

        if (reportCommand != null) {
            reportCommand.execute();
        }
    }
    
}
