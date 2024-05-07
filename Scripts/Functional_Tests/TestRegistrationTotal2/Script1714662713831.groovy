import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('http://students.cs.ndsu.nodak.edu/~myronovy/cs419/register.html')

WebUI.setText(findTestObject('Object Repository/TC2/Page_Registration Form/input_First Name_firstName'), 'first')

WebUI.setText(findTestObject('Object Repository/TC2/Page_Registration Form/input_Last Name_lastName'), 'last')

WebUI.setText(findTestObject('Object Repository/TC2/Page_Registration Form/input_E-mail_email'), 'test@gmail.com')

WebUI.setText(findTestObject('Object Repository/TC2/Page_Registration Form/input_Work Phone_phoneNumber'), '1234567890')

WebUI.selectOptionByValue(findTestObject('Object Repository/TC2/Page_Registration Form/select_Exhibits Only (95.00)               _4b7ffa'), 
    '100', true)

WebUI.setText(findTestObject('Object Repository/TC2/Page_Registration Form/input_VSLive Banquet (80 ea.)_banquetGuests'), 
    '2')

WebUI.click(findTestObject('Object Repository/TC2/Page_Registration Form/span_240.00')) // unfocus guest input box (updates total)

def total = WebUI.getAttribute(findTestObject('Object Repository/TC2/Page_Registration Form/span_240.00'), 'innerText')

assert total == '$240.00'

WebUI.closeBrowser()

