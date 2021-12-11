package Model;

public class Manager extends Account{
    private SummaryReport report;

    //Initializes manager object with correct information
    //Methods and members from class Account can be used to modify manager later
    public Manager () {
        userInfo.setAccountType(AccountType.MANAGER);
    }

    //Creates and invokes a SummaryReport object. SummaryReportController deals with this object
    public void generateSummaryReport() {
        report = new SummaryReport();
        report.generateReport();
    }
    
    //Returns the SummaryReport object
    public SummaryReport getReport() {
        return this.report;
    }

    //Sets the SummaryReport object
    public void setReport(SummaryReport report) {
        this.report = report;
    }
}
