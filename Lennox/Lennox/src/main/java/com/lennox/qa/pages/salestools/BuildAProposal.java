package com.lennox.qa.pages.salestools;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.lennox.qa.base.BaseClass;
import com.lennox.qa.utilities.Xls_Reader;

public class BuildAProposal extends BaseClass {

	@FindBy(xpath = "//a[@class='login-link btn NEEDS_AUTHENTICATION']")
	WebElement signinLink;

	@FindBy(id = "j_username")
	WebElement username;

	@FindBy(id = "j_password")
	WebElement password;

	@FindBy(id = "loginSubmit")
	WebElement loginBtn;

	@FindBy(xpath = "//i[@class='far fa-bars v2-hamburger-menu']")
	WebElement menuTab;

	@FindBy(xpath = "//i[@class='fas fa-chevron-right pull-right menu-right-arrow ']/parent::a[contains(text(),'Sales Tools')]")
	WebElement salesToolBtn;

	@FindBy(xpath = "//a[contains(text(),'Build a Proposal')]")
	WebElement buildAProposalBtn;

	@FindBy(xpath = "//a[contains(text(),'SELECT LEAD')]")
	WebElement selectLeadBtn;

	@FindBy(xpath = "//a[@class='btn btn-primary hide-mobile introjs-l-9 introjs-l-83']")
	WebElement addLeadBtn;

	@FindBy(id = "firstName")
	WebElement firstname;

	@FindBy(id = "lastName")
	WebElement lastname;

	@FindBy(id = "phNo")
	WebElement phoneNumber;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "addressLine1")
	WebElement addressLine1;

	@FindBy(id = "addressLine2")
	WebElement addressLine2;

	@FindBy(id = "countryIso")
	WebElement country;

	@FindBy(id = "regionIso")
	WebElement state;

	@FindBy(id = "townCity")
	WebElement city;

	@FindBy(id = "postal-code")
	WebElement zipcode;

	@FindBy(id = "comments")
	WebElement comments;

	@FindBy(id = "uid")
	WebElement assignedTo;

	@FindBy(id = "status")
	WebElement leadStatus;

	@FindBy(id = "leadSource")
	WebElement leadSource;

	@FindBy(id = "projectType")
	WebElement projectType;

	@FindBy(id = "custom-styled-select input-box")
	WebElement equipmentToInstall;

	@FindBy(xpath = "//div[@class='col-sm-10 equipment-to-install']//span")
	List<WebElement> listDropDown;

	@FindBy(id = "oldSystemManufacturer")
	WebElement oldSystemManufecturer;

	@FindBy(id = "oldSystemDescription")
	WebElement oldSystemDecription;

	@FindBy(xpath = "//input[@id='calender1']")
	WebElement dateRequest;

	@FindBy(xpath = "//input[@id='calender2']")
	WebElement dateAppointment;

	@FindBy(xpath = "//select[@id='scheduleRequestTime']")
	WebElement timeRequest;

	@FindBy(xpath = "//select[@id='appointmentRequestTime']")
	WebElement timeAppointment;

	@FindBy(id = "select0")
	WebElement systemRequested;

	@FindBy(xpath = "//input[@id='sysReq0']")
	WebElement model;

	@FindBy(xpath = "//input[@id='sysRequest0']")
	WebElement catalog;

	@FindBy(name = "acquisitionCost")
	WebElement cost;

	@FindBy(xpath = "//p[contains(text(),'Add Document')]")
	WebElement addDocumentBtn;

	@FindBy(xpath = "//select[@name='documents[1].documentType']")
	WebElement documentType;

	@FindBy(xpath = "//input[@id='multipleFileSelect-1']")
	WebElement selectFileBtn;

	@FindBy(xpath = "//a[@class='btn btn-primary mr-15 add-documents-to-page mb-15']")
	WebElement addLeadButton;

	@FindBy(xpath = "//input[@name='imageFiles']")
	WebElement addImageBtn;

	@FindBy(xpath = "//button[@id='btn-addLeadsForm']")
	WebElement saveLeadBtn;

	@FindBy(xpath = "//div[@class='messages container']//ul[@class='success-msg']")
	WebElement successMsg;

	@FindBy(xpath = "//button[contains(text(),'Create Duplicate')]")
	WebElement duplicateEntry;

	public BuildAProposal() {
		PageFactory.initElements(driver, this);
	}

	public void buildAProposalFromSalesTools() throws InterruptedException {

		signinLink.click();
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		loginBtn.click();

		menuTab.click();
		salesToolBtn.click();
		buildAProposalBtn.click();
		Thread.sleep(3000);
		selectLeadBtn.click();
		addLeadBtn.click();

		String sheetName = "ProposalData";
		Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir") + "\\TestData.xlsx");

		firstname.sendKeys(reader.getCellData(sheetName, 2, 2));
		lastname.sendKeys(reader.getCellData(sheetName, 3, 2));
		phoneNumber.sendKeys(reader.getCellData(sheetName, 4, 2));
		email.sendKeys(reader.getCellData(sheetName, 5, 2));
		addressLine1.sendKeys(reader.getCellData(sheetName, 6, 2));
		addressLine2.sendKeys(reader.getCellData(sheetName, 7, 2));

		Select countryValue = new Select(country);
		countryValue.selectByVisibleText(reader.getCellData(sheetName, 8, 2));

		Select stateValue = new Select(state);
		stateValue.selectByVisibleText(reader.getCellData(sheetName, 9, 2));

		city.sendKeys(reader.getCellData(sheetName, 10, 2));
//		zipcode.sendKeys(reader.getCellData(sheetName, 11, 2));
		comments.sendKeys(reader.getCellData(sheetName, 12, 2));

		Select assignedToValue = new Select(leadStatus);
		assignedToValue.selectByVisibleText(reader.getCellData(sheetName, 13, 2));

		Select leadStatusValue = new Select(leadSource);
		leadStatusValue.selectByVisibleText(reader.getCellData(sheetName, 14, 2));

		Select leadSourceValue = new Select(projectType);
		leadSourceValue.selectByVisibleText(reader.getCellData(sheetName, 15, 2));
		Select EquipmentToInstallValue = new Select(oldSystemManufecturer);
		EquipmentToInstallValue.selectByVisibleText(reader.getCellData(sheetName, 17, 2));

		oldSystemDecription.sendKeys(reader.getCellData(sheetName, 18, 2));

//		String dateValue = "28-12-2020";
//		SelectDate(driver, dateRequest, dateValue);
//
//		Select timeReq = new Select(timeRequest);
//		timeReq.selectByVisibleText("00:00 AM");
//
//		Select timeApp = new Select(timeAppointment);
//		timeApp.selectByVisibleText("02:15 AM");
//
//		String dateValue1 = "28-12-2020";
//		SelectDate(driver, dateAppointment, dateValue1);

		model.sendKeys(reader.getCellData(sheetName, 19, 2));
		catalog.sendKeys(reader.getCellData(sheetName, 20, 2));
//		cost.sendKeys(reader.getCellData(sheetName, 21, 2));

		addDocumentBtn.click();

		Select docType = new Select(documentType);
		docType.selectByVisibleText("OTHER");

		selectFileBtn.sendKeys(System.getProperty("user.dir") + "\\sample1.pdf");
		Thread.sleep(2000);
		addLeadButton.click();
		Thread.sleep(2000);
		addImageBtn.sendKeys(System.getProperty("user.dir") + "\\image.png");
		Thread.sleep(3000);
		saveLeadBtn.click();

		Thread.sleep(4000);
		duplicateEntry.click();

	}

	public String verificationMessage() {
		return successMsg.getText();
	}

	public static void SelectDate(WebDriver driver, WebElement element, String dateValue) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value', '" + dateValue + "');", element);
	}

	public static void SelectTime(WebDriver driver, WebElement element, String timeValue) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value', '" + timeValue + "');", element);
	}

}
