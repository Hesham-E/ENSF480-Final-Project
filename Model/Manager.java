package Model;

public class Manager extends Account{
    private SummaryReport report;

    public Manager () {
        userInfo.setAccountType(AccountType.MANAGER);
    }

    public void generateSummaryReport() {
        report = new SummaryReport();
        report.generateReport();
    }
    
    public SummaryReport getReport() {
        return this.report;
    }

    public void setReport(SummaryReport report) {
        this.report = report;
    }
}
