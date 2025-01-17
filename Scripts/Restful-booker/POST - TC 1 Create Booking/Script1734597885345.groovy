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
import groovy.json.*

def response = WS.sendRequest(findTestObject('object/POST - Create Booking'))

// Verifikasi Status Code
WS.verifyResponseStatusCode(response, 200)

WS.verifyElementPropertyValue(response, 'booking.firstname', nama)

WS.verifyElementPropertyValue(response, 'booking.totalprice', 11000)

// Parsing respons JSON untuk mendapatkan booking ID
def responseBody = response.getResponseBodyContent()

def jsonResponse = new JsonSlurper().parseText(responseBody)

def bookingId = jsonResponse.bookingid

// Simpan booking ID ke Global Variable
GlobalVariable.bookingId = bookingId

println('Parsed JSON Response: ' + jsonResponse)

println('Booking ID: ' + bookingId)

// Log Global Variable untuk memastikan ID tersimpan
println('Booking ID saved to Global Variable: ' + GlobalVariable.bookingId)

