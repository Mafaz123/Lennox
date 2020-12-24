package com.lennox.qa.testcases.SalesTools;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.lennox.qa.base.BaseClass;
import com.lennox.qa.pages.salestools.BuildAProposal;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class BuildAProposalTest extends BaseClass {

	BuildAProposal buildaproposal;

	public BuildAProposalTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		buildaproposal = new BuildAProposal();
	}

	@Test(description = "< Create a New Lead!")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Create a New Lead!!!")
	@Story("#Story Name = Build a New Proposal*")
	public void touchesWorkflowTest() throws InterruptedException, IOException {
		buildaproposal.buildAProposalFromSalesTools();
		String success = buildaproposal.verificationMessage();

		Assert.assertEquals(success, "Lead Saved Successfully", "Lead Saved Successfully");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
