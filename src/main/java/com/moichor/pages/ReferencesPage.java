package com.moichor.pages;

import com.moichor.base.DriverFactory;
import com.moichor.util.ConfigReader;
import com.moichor.util.TestUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Properties;
import java.util.Random;

public class ReferencesPage {

    public WebDriver driver;
    TestUtil ts;
    public JavascriptExecutor js;
    ConfigReader configReader = new ConfigReader();
    Properties prop = configReader.init_prop();

    public ReferencesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = DriverFactory.getDriver();
        this.ts = new TestUtil(driver);

    }

    @FindBy(xpath = "//a[text()='Clinics']")
    private WebElement clinicButton;

    @FindBy(xpath = "//a[text()='References']")
    private WebElement referencesButton;

    @FindBy(xpath = "(//i[@class='simple-icon-drawer'])[1]/..")
    private WebElement binsLink;

    @FindBy(css = "[class*='mb'] h1")
    private WebElement binText;

    @FindBy(id = "search")
    private WebElement searchBar;

    @FindBy(css = "[class*='top-right-button btn btn']")
    private WebElement addBinButton;

    @FindBy(id = "code")
    private WebElement codeInputField;

    @FindBy(id = "priority")
    private WebElement priorityInputField;

    @FindBy(id = "description")
    private WebElement descriptionInputField;

    @FindBy(id = "color")
    private WebElement colorInputField;

    @FindBy(css = "[class='hue-horizontal'] div div")
    private WebElement dragIcon;

    @FindBy(xpath = "//span[contains(@id,'react-select-sample')]/..")
    private WebElement samplePriorityDropDown;

    @FindBy(xpath = "//span[contains(@id,'react-select-sample')]/../descendant::input")
    private WebElement samplePriorityInputField;

    @FindBy(xpath = "//span[contains(@id,'react-select-bin')]/..")
    private WebElement binTimeZoneDropDown;

    @FindBy(xpath = "//span[contains(@id,'react-select-bin')]/../descendant::input")
    private WebElement binTimeZoneInputField;

    @FindBy(xpath = "//span[@id='react-select-tests-live-region']/..")
    private WebElement relatedTestsDropDown;

    @FindBy(xpath = "//span[@id='react-select-tests-live-region']/../descendant::input")
    private WebElement relatedTestInputField;

    @FindBy(css = "[class*='d-inline-flex mx-auto ']")
    private WebElement saveButton;

    @FindBy(css = "[role='status']")
    private WebElement status;

    @FindBy(xpath = "(//div[contains(@class,'d-flex flex-row list')]/..)[1]")
    private WebElement firstBin;

    @FindBy(xpath = "(//div[contains(@class,'mb-1 list-title w')])[1]")
    private WebElement firstCodeID;

    @FindBy(xpath = "(//i[@class='simple-icon-trash primary'])[1]")
    private WebElement deleteIcon;

    @FindBy(css = "[class='modal-body']")
    private WebElement deletePopUp;

    @FindBy(css = "[class*='d-flex btn btn-danger']")
    private WebElement yesButton;

    @FindBy(xpath = "(//i[@class='simple-icon-drawer'])[2]/..")
    private WebElement issueLink;

    @FindBy(css = "[class*='mb'] h1")
    private WebElement issueText;

    @FindBy(css = "[class*='top-right-button btn btn']")
    private WebElement addIssueButton;

    @FindBy(css = "[class='modal-title']")
    private WebElement addIssueTitle;

    @FindBy(id = "title")
    private WebElement titleInputField;

    @FindBy(id = "description")
    private WebElement issueDescriptionInputField;

    @FindBy(xpath = "//span[@id='react-select-status-live-region']/..")
    private WebElement issueStatusDropDown;

    @FindBy(xpath = "//span[@id='react-select-status-live-region']/../descendant::input")
    private WebElement issueStatusInput;

    @FindBy(css = "[class='d-flex btn btn-primary']")
    private WebElement saveIssueButton;

    @FindBy(xpath = "(//span[contains(@class,'list-title w')])[1]")
    private WebElement firstIssueTitle;

    @FindBy(xpath = "(//i[@class='simple-icon-trash primary'])[1]")
    private WebElement firstIssueDeleteIcon;

    @FindBy(css = "[class*='d-flex btn btn-danger']")
    private WebElement deleteIssueYesButton;

    @FindBy(xpath = "//i[@class='simple-icon-chemistry']/..")
    private WebElement variablesLink;

    @FindBy(css = "[class*='mb-2'] h1")
    private WebElement variableText;

    @FindBy(css = "[class*='top-right-button btn btn']")
    private WebElement addVariableButton;

    @FindBy(id = "name")
    private WebElement variableName;

    @FindBy(id = "unit")
    private WebElement variableUnits;

    @FindBy(id = "unit")
    private WebElement variableUnit;

    @FindBy(xpath = "//span[@id='react-select-status-live-region']/..")
    private WebElement visibilityOfClinicDropDown;

    @FindBy(xpath = "//span[@id='react-select-status-live-region']/../descendant::input")
    private WebElement visibilityOfClinicInput;

    @FindBy(xpath = "//span[@id='react-select-type-live-region']/..")
    private WebElement variableTypeDropDown;

    @FindBy(xpath = "//span[@id='react-select-type-live-region']/../descendant::input")
    private WebElement variableTypeInput;

    @FindBy(css = "[class='d-flex btn btn-info']")
    private WebElement variableSubmitButton;

    @FindBy(css = "[class*='btn btn-success btn-sm btn-block']")
    private WebElement addOptionButton;

    @FindBy(css = "[placeholder='Option 1']")
    private WebElement firstOption;

    @FindBy(css = "[placeholder='Option 2']")
    private WebElement secondOption;

    @FindBy(css = "[placeholder='Option 3']")
    private WebElement thirdOption;

    @FindBy(xpath = "//input[@placeholder='Option 1']/../../following-sibling::button")
    private WebElement deleteFirstOption;

    @FindBy(xpath = "//input[@placeholder='Option 2']/../../following-sibling::button")
    private WebElement deleteSecondOption;

    @FindBy(css = "[class*='d-flex flex-row justify-content-between'] button[class='btn btn-danger']")
    private WebElement deleteTheVariable;

    @FindBy(css = "[class*='d-flex btn btn-danger']")
    private WebElement yesButtonForDeleteTheVariable;

    @FindBy(xpath = "(//div[contains(@class,'d-flex flex-row list')]/..)[1]")
    private WebElement firstVariable;

    @FindBy(xpath = "(//div[contains(@class,'d-flex flex-row list')]/..)[1]")
    private WebElement firstVariableID;

    @FindBy(xpath = "//i[@class='simple-icon-chart']/..")
    private WebElement valueLink;

    @FindBy(css = "[class*='mb'] h1")
    private WebElement valueText;

    @FindBy(css = "[class*='top-right-button btn']")
    private WebElement addValueButton;

    @FindBy(css = "[class='modal-body']")
    private WebElement valueDetails;

    @FindBy(xpath = "//span[@id='react-select-variable-live-region']/..")
    private WebElement variablesDropDown;

    @FindBy(xpath = "//span[@id='react-select-variable-live-region']/../descendant::input")
    private WebElement variableInput;

    @FindBy(xpath = "//div[@class='modal-body']/descendant::span[@id='react-select-species-live-region']/..")
    private WebElement speciesDropDown;

    @FindBy(xpath = "//div[@class='modal-body']/descendant::span[@id='react-select-species-live-region']/../descendant::input")
    private WebElement speciesInput;

    @FindBy(id = "text")
    private WebElement defaultText;

    @FindBy(xpath = "//span[@id='react-select-options-live-region']/..")
    private WebElement refValueDropDown;

    @FindBy(xpath = "//span[@id='react-select-options-live-region']/../descendant::input")
    private WebElement refValueInput;

    @FindBy(css = "[class='btn btn-primary']")
    private WebElement valueSubmitButton;

    @FindBy(xpath = "//span[@id='react-select-variables-live-region']/..")
    private WebElement searchTheValueByVariableNameDropDown;

    @FindBy(xpath = "//span[@id='react-select-variables-live-region']/../descendant::input")
    private WebElement searchTheValueByVariableNameInputField;

    @FindBy(xpath = "(//span[@id='react-select-variables-live-region']/../descendant::div[contains(@class,'indicatorContainer')])[1]")
    private WebElement variableDropDownCancelIcon;

    @FindBy(xpath = "(//div[contains(@class,'min-width-zero')]/p)[1]")
    private WebElement firstValue;

    @FindBy(css = "[class='btn btn-outline-primary']")
    private WebElement editTheValue;

    @FindBy(css = "[class='btn btn-outline-danger']")
    private WebElement deleteValueButton;

    @FindBy(css = "[class*='d-flex btn btn-danger']")
    private WebElement yesButtonForDeleteValue;

    @FindBy(xpath = "//span[@id='react-select-species-live-region']/..")
    private WebElement searchSpeciesDropDown;

    @FindBy(xpath = "//span[@id='react-select-species-live-region']/../descendant::input")
    private WebElement searchSpeciesInput;

    @FindBy(xpath = "(//span[@id='react-select-species-live-region']/../descendant::div[contains(@class,'indicatorContainer')])[1]")
    private WebElement speciesDropDownCancelIcon;

    @FindBy(css = "[class='w-full' ] input[id='searchGenus']")
    private WebElement genusInputField;

    @FindBy(css = "[class='w-full'] input[id='searchCname']")
    private WebElement commonNameInputField;

    @FindBy(id = "searchBreedName")
    private WebElement breedInputField;

    @FindBy(xpath = "(//i[@class='iconsminds-sheep'])[2]/..")
    private WebElement speciesLink;

    @FindBy(css = "[class*='mb'] h1")
    private WebElement speciesText;

    @FindBy(css = "[class*='top-right-button btn']")
    private WebElement addSpeciesButton;

    @FindBy(css = "[class='modal-header'] h5")
    private WebElement addSpeciesText;

    @FindBy(id = "cname")
    private WebElement commonNameInput;

    @FindBy(id = "genus")
    private WebElement genusNameInput;

    @FindBy(id = "species")
    private WebElement speciesNameInput;

    @FindBy(id = "custom_id")
    private WebElement customIdField;

    @FindBy(id = "billing_code")
    private WebElement billingCode;

    @FindBy(id = "juvenile")
    private WebElement juvenileInput;

    @FindBy(id = "geriatic")
    private WebElement geriaticInput;

    @FindBy(xpath = "//span[@id='react-select-reference_species-live-region']/..")
    private WebElement referenceSpeciesDropDown;

    @FindBy(xpath = "//span[@id='react-select-reference_species-live-region']/../descendant::input")
    private WebElement referenceSpeciesInput;

    @FindBy(xpath = "//span[@id='react-select-tests-live-region']/..")
    private WebElement selectRelatedTestDropDown;

    @FindBy(xpath = "//span[@id='react-select-tests-live-region']/../descendant::input")
    private WebElement selectRelatedTestInput;

    @FindBy(css = "[class='d-flex btn btn-info']")
    private WebElement addSpeciesSubmitButton;

    @FindBy(id = "searchCustomId")
    private WebElement searchCustomID;

    @FindBy(xpath = "(//div[contains(@class,'d-flex flex-row list-title')]/div)[1]")
    private WebElement speciesID;

    @FindBy(id = "searchId")
    private WebElement searchTheID;

    @FindBy(id = "searchGenus")
    private WebElement searchGenus;

    @FindBy(id = "searchSpecies")
    private WebElement searchSpecies;

    @FindBy(id = "searchCommonName")
    private WebElement searchCommonName;

    @FindBy(xpath = "(//div[contains(@class,'d-flex flex-row list-title')]/div)[6]")
    private WebElement referenceID;

    @FindBy(id = "searchReferenceId")
    private WebElement searchTheReference;

    @FindBy(css = "[class*='btn btn-danger']")
    private WebElement deleteTheAddedSpecie;

    @FindBy(css = "[class*='d-flex btn btn-danger']")
    private WebElement yesButtonForDeleteTheSpecie;

    @FindBy(xpath = "//i[@class='simple-icon-question']/..")
    private WebElement questionsLink;

    @FindBy(css = "[class*='mb'] h1")
    private WebElement questionText;

    @FindBy(css = "[class*='top-right-button btn']")
    private WebElement addQuestionButton;

    @FindBy(css = "[class='modal-header'] h5")
    private WebElement questionFormText;

    @FindBy(id = "text")
    private WebElement questionInputField;

    @FindBy(css = "[class*='border-bottom']")
    private WebElement options;

    @FindBy(css = "[class*='input-group'] input")
    private WebElement optionsInput;

    @FindBy(css = "[class='input-group-append'] button")
    private WebElement addOptionsButton;

    @FindBy(css = "[class='btn btn-info']")
    private WebElement submitButtonForQuestions;

    @FindBy(xpath = "(//div[@class='d-flex flex-row list-item-card card']/*/*/*/p)[2]")
    private WebElement addedQuestion;

    @FindBy(css = "[class='search-icon icon'] i")
    private WebElement cancelIcon;

    @FindBy(css = "[class='btn btn-danger']")
    private WebElement deleteTheAddedQuestion;

    @FindBy(css = "[class*='d-flex btn btn-danger']")
    private WebElement yesButtonForDeleteTheQuestion;

    @FindBy(xpath = "//ul[@data-parent='references']/descendant::i[@class='iconsminds-microscope']/..")
    private WebElement testLink;

    @FindBy(css = "[class*='mb'] h1")
    private WebElement testText;

    @FindBy(css = "[class='top-right-button btn btn-success btn-lg']")
    private WebElement addTestButton;

    @FindBy(css = "[class='modal-header'] h5")
    private WebElement addTestText;

    @FindBy(id = "name")
    private WebElement testNameInputField;

    @FindBy(id = "alias")
    private WebElement aliasInputField;

    @FindBy(id = "description")
    private WebElement descriptionField;

    @FindBy(id = "label_tool_set")
    private WebElement labelToolInputField;

    @FindBy(id = "model_name")
    private WebElement modelNameInputField;

    @FindBy(xpath = "//table/tbody/tr/td/input[contains(@name,'pricing')]")
    private WebElement defaultPriceInputField;

    @FindBy(css = "[class='d-flex btn btn-outline-success']")
    private WebElement saveButtonForTest;

    @FindBy(xpath = "(//div[contains(@class,'card-body')]/*)[1]")
    private WebElement firstTestID;

    @FindBy(xpath = "(//div[contains(@class,'card-body')]/*/*)[1]")
    private WebElement firstTestName;

    @FindBy(xpath = "(//ul[@class='d-block nav']/descendant::i[@class='iconsminds-box-with-folders'])[1]/..")
    private WebElement testGroupLink;

    @FindBy(css = "[class*='mb'] h1")
    private WebElement testGroupText;

    @FindBy(css = "[class*='custom-mt dropdown']")
    private WebElement sortFilterDropDown;

    @FindBy(css = "[class='top-right-button btn btn-success btn-lg']")
    private WebElement addTestGroup;

    @FindBy(css = "[class='modal-header'] h5")
    private WebElement addTestGroupText;

    @FindBy(css = "[class*='form-control br']")
    private WebElement testGroupNameTextInputField;

    @FindBy(css = "[class='d-flex btn btn-info']")
    private WebElement addTestGroupSaveButton;

    @FindBy(xpath = "(//div[contains(@class,'card-body')])[1]/p")
    private WebElement firstTestGroupID;

    @FindBy(xpath = "(//div[contains(@class,'mb-2 col')]/*/*/*/*/*)[1]")
    private WebElement firstTestGroupName;

    @FindBy(css = "[class='btn btn-danger']")
    private WebElement deleteTestGroupButton;

    @FindBy(css = "[class*=' d-flex btn btn-danger']")
    private WebElement yesButtonForDeleteTestGroup;

    @FindBy(css = "[class='dropdown-menu show'] button")
    private List<WebElement> sortingFilterDropDownElements;

    @FindBy(xpath = "(//ul[@class='d-block nav']/descendant::i[@class='iconsminds-box-with-folders'])[2]/..")
    private WebElement itemsLink;

    @FindBy(css = "[class*='mb'] h1")
    private WebElement itemText;

    @FindBy(css = "[class*='custom-mt dropdown']")
    private WebElement itemSortingFilterDropDown;

    @FindBy(css = "[class*='top-right-button btn']")
    private WebElement addItemButton;

    @FindBy(css = "[class='modal-header'] h5")
    private WebElement addItemText;

    @FindBy(css = "[name='name']")
    private WebElement itemNameInputField;

    @FindBy(css = "[name='unit']")
    private WebElement itemUnitInputField;

    @FindBy(css = "[name='vendor_name']")
    private WebElement itemVendorNameInputField;

    @FindBy(css = "[name='url']")
    private WebElement itemURLInputField;

    @FindBy(css = "[name='pricing']")
    private WebElement itemPricingInputField;

    @FindBy(css = "[name='inventory']")
    private WebElement itemInventoryInputField;

    @FindBy(css = "[name='threshold']")
    private WebElement itemThresholdInputField;

    @FindBy(css = "[class='btn btn-info']")
    private WebElement addItemSubmitButton;

    @FindBy(xpath = "(//div[contains(@class,'card-body ')]/*)[1]")
    private WebElement firstItemID;

    @FindBy(xpath = "(//div[contains(@class,'card-body ')]/*/*)[1]")
    private WebElement firstItemName;

    @FindBy(css = "[class*='btn btn-danger']")
    private WebElement deleteTheItemButton;

    @FindBy(css = "[class*='d-flex btn btn-danger']")
    private WebElement yesButtonForDeletingItem;

    @FindBy(css = "input[type='file']")
    private WebElement imageInputField;

    @FindBy(xpath = "(//i[@class='iconsminds-box-close']/..)[1]")
    private WebElement bundleLink;

    @FindBy(css = "[class*='mb'] h1")
    private WebElement bundleText;

    @FindBy(xpath = "//i[@class='simple-icon-arrow-down']")
    private WebElement downArrow;

    @FindBy(css = "[class*='top-right-button btn btn-success']")
    private WebElement addBundleButton;

    @FindBy(css = "[class='modal-header'] h5")
    private WebElement addBundleText;

    @FindBy(xpath = "(//label[text()='Name']/following-sibling::input)[1]")
    private WebElement bundleNameInputField;

    @FindBy(xpath = "//div[contains(@id,'placeholder')]/../..")
    private WebElement addReferenceTestToBundleDropDown;

    @FindBy(xpath = "//div[contains(@id,'placeholder')]/../../descendant::input")
    private WebElement addReferenceTestToBundleInputField;

    @FindBy(xpath = "//div[contains(@class,'react-select__indicator react-select__clear')]/*[name()='svg']")
    private WebElement cancelButton;

    @FindBy(css = "[class='btn btn-secondary']")
    private WebElement referenceTestAddButton;

    @FindBy(css = "[role='listbox'] [role='option']")
    private List<WebElement> allReferenceTests;

    @FindBy(css = "[class='btn btn-info']")
    private WebElement addBundleSubmitButton;

    @FindBy(xpath = "(//div[@class='mb-2 col-12']/*/*/*/*/*/*)[1]")
    private WebElement firstBundleName;

    @FindBy(css = "[class*='mt-4 btn btn-danger']")
    private WebElement deleteTheAddedBundleButton;

    @FindBy(css = "[class*='d-flex btn btn-danger']")
    private WebElement yesButtonForDeletingBundle;

    @FindBy(css = "[class*='simple-icon-arrow']")
    private WebElement upDownArrow;

    @FindBy(xpath = "(//span[contains(@class,'cursor-pointer')])[1]/*")
    private WebElement idText;

    @FindBy(xpath = "(//i[@class='iconsminds-box-close']/..)[2]")
    private WebElement volumeTierLink;

    @FindBy(css = "[class*='mb'] h1")
    private WebElement volumeTierText;

    @FindBy(css = "[class*='top-right-button btn']")
    private WebElement addVolumeButton;

    @FindBy(css = "[name='name']")
    private WebElement volumeTierNameInputField;

    @FindBy(css = "[name='min_order']")
    private WebElement minOrderInputField;

    @FindBy(css = "[name='max_order']")
    private WebElement maxOrderInputField;

    @FindBy(xpath = "//div[contains(@id,'placeholder')]/../../..")
    private WebElement referenceBundleDropDown;

    @FindBy(xpath = "//div[contains(@id,'placeholder')]/../../../descendant::input[@id]")
    private WebElement referenceBundleInputField;

    @FindBy(css = "[role='listbox'] [role='option']")
    private List<WebElement> allReferenceBundle;

    @FindBy(css = "[class='btn btn-info']")
    private WebElement addVolumeSubmitButton;

    @FindBy(css = "[class='btn btn-outline-primary']")
    private WebElement addVolumeCancelButton;

    @FindBy(xpath = "(//div[@class='d-flex flex-row list-item-card card']/*/*/*/*)[1]")
    private WebElement firstTierName;

    @FindBy(css = "[class*='btn btn-danger']")
    private WebElement deleteVolumeTierButton;

    @FindBy(css = "[class*='d-flex btn btn-danger']")
    private WebElement yesButtonForDeletingVolumeTier;

    @FindBy(xpath = "(//i[@class='iconsminds-box-close']/..)[3]")
    private WebElement clinicalTemplateLink;

    @FindBy(css = "[class*='top-right-button btn']")
    private WebElement addClinicalTemplateButton;

    @FindBy(css = "[name='template_name']")
    private WebElement templateNameInputField;

    @FindBy(xpath = "//div[contains(@id,'placeholder')]/../../..")
    private WebElement templateTypeDropDown;

    @FindBy(xpath = "//div[contains(@id,'placeholder')]/../../../descendant::input")
    private WebElement templateTypeInputField;

    @FindBy(css = "[role='listbox'] [role='option']")
    private List<WebElement> allTypes;

    @FindBy(css = "[name='body']")
    private WebElement templateBodyInputField;

    @FindBy(css = "[class='btn btn-info']")
    private WebElement templateSubmitButton;

    @FindBy(xpath = "(//div[@class='d-flex flex-row list-item-card card']/*/*/*/p)[1]")
    private WebElement firstClinicalTemplateID;

    @FindBy(xpath = "(//div[@class='d-flex flex-row list-item-card card']/*/*/*/*/p)[1]")
    private WebElement firstClinicalTemplateName;

    @FindBy(css = "[name='description']")
    private WebElement templateDescriptionInputTextField;

    @FindBy(css = "[class*='btn btn-danger']")
    private WebElement deleteClinicalTemplateButton;

    @FindBy(css = "[class*='d-flex btn btn-danger']")
    private WebElement yesButtonForDeletingClinicalTemplate;

    @FindBy(xpath = "//i[@class='iconsminds-fit-to']/..")
    private WebElement conditionsLink;

    @FindBy(css = "[class*='mb'] h1")
    private WebElement conditionsText;

    @FindBy(css = "[class*='top-right-button btn']")
    private WebElement addConditionsButton;

    @FindBy(css = "[class='modal-header'] h5")
    private WebElement conditionsFormText;

    @FindBy(xpath = "//div[@id='react-select-reftests-placeholder']/../../..")
    private WebElement referenceTestDropDown;

    @FindBy(xpath = "//div[@id='react-select-reftests-placeholder']/../../../descendant::input")
    private WebElement referenceTestInputField;

    @FindBy(css = "[class='btn btn-primary']")
    private WebElement addConditionSubmitButton;

    @FindBy(id = "condition_text")
    private WebElement conditionsTextInputField;

    @FindBy(xpath = "(//div[@class='d-flex flex-column flex-lg-row min-width-zero align-items-lg-center']/*/*)[1]")
    private WebElement firstCondition;

    @FindBy(css = "[class*='btn btn-danger']")
    private WebElement deleteConditionsButton;

    @FindBy(css = "[class*='d-flex btn btn-danger']")
    private WebElement yesButtonForDeletingConditions;

    @FindBy(xpath = "//i[@class='iconsminds-check']/..")
    private WebElement tasksLink;

    @FindBy(css = "[class*='top-right-button btn']")
    private WebElement addNewTaskButton;

    @FindBy(css = "[class='modal-header'] h5")
    private WebElement tasksForm;

    @FindBy(id = "name")
    private WebElement tasksNameInputField;

    @FindBy(xpath = "//div[@id='react-select-clinics-placeholder']/../../..")
    private WebElement taskAvailableDropDown;

    @FindBy(xpath = "//div[@id='react-select-clinics-placeholder']/../../../descendant::input")
    private WebElement taskAvailableInput;

    @FindBy(css = "[role='listbox'] [role='option']")
    private List<WebElement> allElements;

    @FindBy(xpath = "//div[contains(@id,'test-placeholder')]/../../..")
    private WebElement refTestDropDown;

    @FindBy(xpath = "//div[contains(@id,'test-placeholder')]/../../../descendant::input")
    private WebElement refTestInputField;

    @FindBy(xpath = "//div[contains(@id,'status-placeholder')]/../../..")
    private WebElement selectStatusDropDown;

    @FindBy(xpath = "//div[contains(@id,'status-placeholder')]/../../../descendant::input")
    private WebElement selectStatusInput;

    @FindBy(css = "[class='d-flex btn btn-primary']")
    private WebElement addTaskSubmitButton;

    @FindBy(xpath = "(//div[@class='d-flex flex-row list-item-card card']/*/*/*/p)[1]")
    private WebElement firstTaskName;

    @FindBy(css = "[class='add_more_test'] span")
    private WebElement addMoreLink;

    @FindBy(xpath = "//div[contains(@id,'1.test-placeholder')]/../../..")
    private WebElement secondRefTestDropDown;

    @FindBy(xpath = "//div[contains(@id,'1.test-placeholder')]/../../../descendant::input")
    private WebElement secondRefTestInputField;

    @FindBy(xpath = "//div[contains(@id,'1.status-placeholder')]/../../..")
    private WebElement secondSelectStatusDropDown;

    @FindBy(xpath = "//div[contains(@id,'1.status-placeholder')]/../../../descendant::input")
    private WebElement secondSelectStatusInputField;

    @FindBy(css = "[class*='btn btn-danger']")
    private WebElement deleteTaskButton;

    @FindBy(css = "[class*='d-flex btn btn-danger']")
    private WebElement yesButtonForDeletingTask;

    public void clickOnReferenceButton() {
        ts.presenceOfElementWait(clinicButton);
        ts.scrollIntoView(referencesButton);
        referencesButton.click();
        ts.presenceOfElementWait(binsLink);

    }

    Random r = new Random();
    int random = r.nextInt(100);

    public void addABin() throws InterruptedException {
        ts.presenceOfElementWait(binsLink);
        binsLink.click();
        ts.presenceOfElementWait(binText);
        ts.presenceOfElementWait(searchBar);
        ts.presenceOfElementWait(addBinButton);
        addBinButton.click();
        ts.presenceOfElementWait(codeInputField);
        String code = prop.getProperty("codeName");
        codeInputField.sendKeys(random + code);
        ts.presenceOfElementWait(priorityInputField);
        Random r1 = new Random();
        int priority = r1.nextInt(20);
        String number = Integer.toString(priority);
        priorityInputField.clear();
        priorityInputField.sendKeys(number);
        ts.presenceOfElementWait(descriptionInputField);
        String description = prop.getProperty("description");
        descriptionInputField.sendKeys(description);
        ts.presenceOfElementWait(colorInputField);
        ts.presenceOfElementWait(dragIcon);
        ts.doActionsDragOperation(dragIcon, 150, 0);
        ts.presenceOfElementWait(samplePriorityDropDown);
        samplePriorityDropDown.click();
        ts.presenceOfElementWait(samplePriorityInputField);
        String samplePriority = prop.getProperty("samplePriority");
        samplePriorityInputField.sendKeys(samplePriority);
        samplePriorityInputField.sendKeys(Keys.ENTER);
        ts.presenceOfElementWait(binTimeZoneDropDown);
        binTimeZoneDropDown.click();
        ts.presenceOfElementWait(binTimeZoneInputField);
        String time = prop.getProperty("timeZone");
        binTimeZoneInputField.sendKeys(time);
        binTimeZoneInputField.sendKeys(Keys.ENTER);
        ts.presenceOfElementWait(relatedTestsDropDown);
        relatedTestsDropDown.click();
        ts.presenceOfElementWait(relatedTestInputField);
        String test = prop.getProperty("relatedTestName");
        relatedTestInputField.sendKeys(test);
        Thread.sleep(4000);
        relatedTestInputField.sendKeys(Keys.ENTER);
        ts.presenceOfElementWait(saveButton);
        saveButton.click();
        ts.presenceOfElementWait(status);

    }

    public void searchForAddedBin() {
        ts.presenceOfElementWait(searchBar);
        String code = prop.getProperty("codeName");
        searchBar.sendKeys(random + code);
        ts.presenceOfElementWait(firstBin);
    }

    public void editTheBin() throws InterruptedException {
        Thread.sleep(2000);
        ts.presenceOfElementWait(firstCodeID);
        firstCodeID.click();
        ts.presenceOfElementWait(dragIcon);
        ts.doActionsDragOperation(dragIcon, 250, 0);
        ts.presenceOfElementWait(descriptionInputField);
        ts.presenceOfElementWait(saveButton);
        saveButton.click();
        ts.presenceOfElementWait(status);
    }

    public void deleteTheBin() {
        ts.presenceOfElementWait(deleteIcon);
        deleteIcon.click();
        ts.presenceOfElementWait(deletePopUp);
        ts.presenceOfElementWait(yesButton);
        yesButton.click();
        ts.presenceOfElementWait(status);

    }

    char c = (char) (r.nextInt(26) + 'a');

    public void addAIssue() throws InterruptedException {
        ts.presenceOfElementWait(issueLink);
        issueLink.click();
        ts.presenceOfElementWait(issueText);
        ts.presenceOfElementWait(searchBar);
        ts.presenceOfElementWait(addIssueButton);
        addIssueButton.click();
        ts.presenceOfElementWait(addIssueTitle);
        ts.presenceOfElementWait(titleInputField);
        String title = prop.getProperty("issueTitle");
        titleInputField.sendKeys(title + c);
        ts.presenceOfElementWait(issueDescriptionInputField);
        String description = prop.getProperty("issueDescription");
        issueDescriptionInputField.sendKeys(description);
        ts.presenceOfElementWait(issueStatusDropDown);
        issueStatusDropDown.click();
        ts.presenceOfElementWait(issueStatusInput);
        String statusOFIssue = prop.getProperty("issueStatus");
        issueStatusInput.sendKeys(statusOFIssue);
        Thread.sleep(2000);
        issueStatusInput.sendKeys(Keys.ENTER);
        ts.presenceOfElementWait(saveIssueButton);
        saveIssueButton.click();
        ts.presenceOfElementWait(status);

    }

    public void searchForAnAddedIssue() {
        ts.presenceOfElementWait(searchBar);
        String title = prop.getProperty("issueTitle");
        searchBar.sendKeys(title);
        ts.presenceOfElementWait(firstIssueTitle);

    }

    public void editTheIssue() {
        ts.presenceOfElementWait(firstIssueTitle);
        firstIssueTitle.click();
        ts.presenceOfElementWait(issueStatusDropDown);
        issueStatusDropDown.click();
        ts.presenceOfElementWait(issueStatusInput);
        String issueStatus = prop.getProperty("editIssueStatus");
        issueStatusInput.sendKeys(issueStatus);
        issueStatusInput.sendKeys(Keys.ENTER);
        ts.presenceOfElementWait(saveIssueButton);
        saveIssueButton.click();
        ts.presenceOfElementWait(status);

    }

    public void deleteTheIssue() throws InterruptedException {
        ts.presenceOfElementWait(firstIssueDeleteIcon);
        Thread.sleep(4000);
        firstIssueDeleteIcon.click();
        ts.presenceOfElementWait(deletePopUp);
        ts.presenceOfElementWait(deleteIssueYesButton);
        deleteIssueYesButton.click();
        ts.presenceOfElementWait(status);
    }

    public void addAVariable() throws InterruptedException {
        ts.presenceOfElementWait(variablesLink);
        variablesLink.click();
        ts.presenceOfElementWait(variableText);
        ts.presenceOfElementWait(searchBar);
        ts.presenceOfElementWait(addVariableButton);
        addVariableButton.click();
        ts.presenceOfElementWait(variableName);
        String name = prop.getProperty("variableName");
        variableName.sendKeys(name + random);
        ts.presenceOfElementWait(variableUnit);
        String unit = prop.getProperty("variableUnit");
        variableUnit.sendKeys(unit);
        ts.presenceOfElementWait(visibilityOfClinicDropDown);
        visibilityOfClinicDropDown.click();
        ts.presenceOfElementWait(visibilityOfClinicInput);
        String visibility = prop.getProperty("variableVisibilityForClinic");
        visibilityOfClinicInput.sendKeys(visibility);
        Thread.sleep(2000);
        visibilityOfClinicInput.sendKeys(Keys.ENTER);
        ts.presenceOfElementWait(variableTypeDropDown);
        variableTypeDropDown.click();
        ts.presenceOfElementWait(variableTypeInput);
        String variableType = prop.getProperty("variableType");
        List<WebElement> allOptions = driver.findElements(By.cssSelector("[role='option']"));
        for (WebElement r : allOptions) {
            String text = r.getText();
            if (variableType.equalsIgnoreCase(text)) {
                variableTypeInput.sendKeys(variableType);
                Thread.sleep(2000);
                variableTypeInput.sendKeys(Keys.ENTER);
                try {
                    ts.waitForTheElementVisibility(addOptionButton, 5);
                    addOptionButton.click();
                    ts.presenceOfElementWait(firstOption);
                    firstOption.sendKeys("a1");
                    addOptionButton.click();
                    ts.presenceOfElementWait(secondOption);
                    secondOption.sendKeys("a2");
                    addOptionButton.click();
                    ts.presenceOfElementWait(thirdOption);
                    thirdOption.sendKeys("a3");
                    ts.presenceOfElementWait(deleteFirstOption);
                    deleteFirstOption.click();
                    break;
                } catch (Exception e) {
                    break;
                }


            }


        }
        String toggle = prop.getProperty("toggleButton");
        driver.findElement(By.xpath("//label[text()='" + toggle + "']/../button")).click();
        ts.presenceOfElementWait(variableSubmitButton);
        variableSubmitButton.click();
        ts.presenceOfElementWait(status);
    }

    public void searchForTheVariable() {
        ts.presenceOfElementWait(searchBar);
        String name = prop.getProperty("variableName");
        searchBar.sendKeys(name + random);
        ts.presenceOfElementWait(firstVariable);

    }

    public void editTheVariable() throws InterruptedException {
        ts.presenceOfElementWait(firstVariableID);
        Thread.sleep(2000);
        firstVariableID.click();
        ts.presenceOfElementWait(visibilityOfClinicDropDown);
        ts.presenceOfElementWait(visibilityOfClinicInput);
        String visibility = prop.getProperty("editVariableVisibilityForClinic");
        visibilityOfClinicInput.sendKeys(visibility);
        String toggle = prop.getProperty("editToggleButton");
        driver.findElement(By.xpath("//label[text()='" + toggle + "']/../button")).click();
        ts.presenceOfElementWait(variableSubmitButton);
        variableSubmitButton.click();
        ts.presenceOfElementWait(status);
    }

    public void deleteTheVariable() throws InterruptedException {
        ts.presenceOfElementWait(firstVariableID);
        Thread.sleep(2000);
        firstVariableID.click();
        Thread.sleep(2000);
        ts.scrollPageDown();
        ts.presenceOfElementWait(deleteTheVariable);
        deleteTheVariable.click();
        Thread.sleep(2000);
        ts.presenceOfElementWait(yesButtonForDeleteTheVariable);
        yesButtonForDeleteTheVariable.click();
        Thread.sleep(2000);
        ts.presenceOfElementWait(status);

    }

    public void addAValue() throws InterruptedException {
        ts.presenceOfElementWait(referencesButton);
        referencesButton.click();
        Thread.sleep(2000);
        ts.presenceOfElementWait(valueLink);
        valueLink.click();
        Thread.sleep(2000);
        ts.presenceOfElementWait(valueText);
        ts.presenceOfElementWait(addValueButton);
        addValueButton.click();
        ts.presenceOfElementWait(valueDetails);
        ts.presenceOfElementWait(variablesDropDown);
        variablesDropDown.click();
        ts.presenceOfElementWait(variableInput);
        String variableName = prop.getProperty("variableName");
        variableInput.sendKeys(variableName + random);
        Thread.sleep(4000);
        variableInput.sendKeys(Keys.ENTER);
        ts.presenceOfElementWait(speciesDropDown);
        speciesDropDown.click();
        ts.presenceOfElementWait(speciesInput);
        String speciesName = prop.getProperty("speciesNameForValue");
        speciesInput.sendKeys(speciesName);
        Thread.sleep(2000);
        speciesInput.sendKeys(Keys.ENTER);
        String variableType = prop.getProperty("variableType");
        if (variableType.equalsIgnoreCase("categorical") || variableType.equalsIgnoreCase("multicategorical")) {
            ts.presenceOfElementWait(refValueDropDown);
            refValueDropDown.click();
            ts.presenceOfElementWait(refValueInput);
            refValueInput.sendKeys(Keys.ENTER);
            ts.presenceOfElementWait(valueSubmitButton);
            valueSubmitButton.click();
            ts.presenceOfElementWait(status);
        } else {
            ts.presenceOfElementWait(defaultText);
            String defaultValue = prop.getProperty("defaultText");
            defaultText.sendKeys(defaultValue);
            ts.presenceOfElementWait(valueSubmitButton);
            valueSubmitButton.click();
            ts.presenceOfElementWait(status);
        }
    }

    public void searchTheValue() throws InterruptedException {
        ts.presenceOfElementWait(searchTheValueByVariableNameDropDown);
        searchTheValueByVariableNameDropDown.click();
        String variableName = prop.getProperty("variableName");
        searchTheValueByVariableNameInputField.sendKeys(variableName + random);
        Thread.sleep(2000);
        searchTheValueByVariableNameInputField.sendKeys(Keys.ENTER);
        ts.presenceOfElementWait(firstValue);
    }

    public void editTheValue() throws InterruptedException {
        ts.presenceOfElementWait(firstValue);
        firstValue.click();
        ts.presenceOfElementWait(editTheValue);
        editTheValue.click();
        try {
            ts.waitForTheElementVisibility(defaultText, 5);
            defaultText.clear();
            String defaultValue = prop.getProperty("editDefaultText");
            defaultText.sendKeys(defaultValue);
        } catch (Exception e) {
            ts.waitForTheElementVisibility(refValueDropDown, 5);
            refValueDropDown.click();
            ts.waitForTheElementVisibility(refValueInput, 5);
            refValueInput.sendKeys("a3");

        }
        ts.presenceOfElementWait(valueSubmitButton);
        valueSubmitButton.click();
        ts.presenceOfElementWait(status);
    }

    public void deleteTheValue() throws InterruptedException {
        ts.presenceOfElementWait(firstValue);
        firstValue.click();
        ts.presenceOfElementWait(deleteValueButton);
        deleteValueButton.click();
        ts.presenceOfElementWait(yesButtonForDeleteValue);
        yesButtonForDeleteValue.click();
        ts.presenceOfElementWait(status);
        Thread.sleep(2000);
        ts.presenceOfElementWait(referencesButton);
        referencesButton.click();
        ts.presenceOfElementWait(variablesLink);
        variablesLink.click();
        deleteTheVariable();

    }

    public void searchTheValueBySpeciesDropDown() throws InterruptedException {
        ts.presenceOfElementWait(searchSpeciesDropDown);
        searchSpeciesDropDown.click();
        ts.presenceOfElementWait(searchSpeciesInput);
        String speciesName = prop.getProperty("speciesNameForValue");
        searchSpeciesInput.sendKeys(speciesName);
        Thread.sleep(2000);
        searchSpeciesInput.sendKeys(Keys.ENTER);
        ts.presenceOfElementWait(firstValue);
        ts.presenceOfElementWait(speciesDropDownCancelIcon);
        speciesDropDownCancelIcon.click();
    }

    public void searchTheValueByGenus() {

        ts.presenceOfElementWait(genusInputField);
        String genusName = prop.getProperty("genusName");
        genusInputField.sendKeys(genusName);
        ts.presenceOfElementWait(firstValue);
        genusInputField.clear();
    }

    public void searchTheValueByCommonName() {

        ts.presenceOfElementWait(commonNameInputField);
        String speciesName = prop.getProperty("speciesNameForValue");
        commonNameInputField.sendKeys(speciesName);
        ts.presenceOfElementWait(firstValue);
        commonNameInputField.clear();

    }

    public void searchTheValueByBreedName() throws InterruptedException {
        ts.presenceOfElementWait(referencesButton);
        referencesButton.click();
        Thread.sleep(2000);
        ts.presenceOfElementWait(valueLink);
        valueLink.click();
        Thread.sleep(2000);
        ts.presenceOfElementWait(valueText);
        ts.presenceOfElementWait(breedInputField);
        String breedName=prop.getProperty("breedName");
        breedInputField.sendKeys(breedName);
        try {
            ts.waitForTheElementVisibility(firstValue,5);
        }
        catch (Exception e)
        {

        }
        breedInputField.clear();

    }

    int idOfCustom = r.nextInt(1000);

    public void addNewSpecies() throws InterruptedException {
        Thread.sleep(2000);
        ts.presenceOfElementWait(speciesLink);
        speciesLink.click();
        ts.presenceOfElementWait(speciesText);
        ts.presenceOfElementWait(addSpeciesButton);
        addSpeciesButton.click();
        ts.presenceOfElementWait(addSpeciesText);
        ts.presenceOfElementWait(commonNameInput);
        String cName = prop.getProperty("commonName");
        commonNameInput.sendKeys(cName);
        ts.presenceOfElementWait(genusNameInput);
        String genusName = prop.getProperty("genus");
        genusNameInput.sendKeys(genusName);
        ts.presenceOfElementWait(speciesNameInput);
        String species = prop.getProperty("species");
        speciesNameInput.sendKeys(species);
        ts.presenceOfElementWait(customIdField);
        customIdField.sendKeys("71" + idOfCustom);
        ts.presenceOfElementWait(billingCode);
        String billingID = prop.getProperty("billingCode");
        billingCode.sendKeys(billingID);
        ts.presenceOfElementWait(juvenileInput);
        String juvenileNumber = prop.getProperty("juvenile");
        juvenileInput.sendKeys(juvenileNumber);
        ts.presenceOfElementWait(geriaticInput);
        String geriaticNumber = prop.getProperty("geriatic");
        geriaticInput.sendKeys(geriaticNumber);
        ts.presenceOfElementWait(referenceSpeciesDropDown);
        referenceSpeciesDropDown.click();
        ts.presenceOfElementWait(referenceSpeciesInput);
        String speName = prop.getProperty("referenceSpeciesName");
        referenceSpeciesInput.sendKeys(speName);
        Thread.sleep(2000);
        referenceSpeciesInput.sendKeys(Keys.ENTER);
        ts.presenceOfElementWait(selectRelatedTestDropDown);
        selectRelatedTestDropDown.click();
        ts.presenceOfElementWait(selectRelatedTestInput);
        String test = prop.getProperty("selectTest");
        Thread.sleep(2000);
        selectRelatedTestInput.sendKeys(Keys.ENTER);
        ts.presenceOfElementWait(addSpeciesSubmitButton);
        addSpeciesSubmitButton.click();
        ts.presenceOfElementWait(status);
    }

    String addedSpeciesID;
    String reference;

    public void searchTheSpecies() {
        ts.presenceOfElementWait(searchCustomID);
        searchCustomID.sendKeys("71" + idOfCustom);
        ts.presenceOfElementWait(speciesID);
        addedSpeciesID = speciesID.getText();
        searchCustomID.clear();
        ts.presenceOfElementWait(searchTheID);
        searchTheID.sendKeys(addedSpeciesID);
        ts.presenceOfElementWait(speciesID);
        searchTheID.clear();
        ts.presenceOfElementWait(searchGenus);
        String gNAme = prop.getProperty("genus");
        searchGenus.sendKeys(gNAme);
        ts.presenceOfElementWait(speciesID);
        searchGenus.clear();
        ts.presenceOfElementWait(searchSpecies);
        String specName = prop.getProperty("species");
        searchSpecies.sendKeys(specName);
        ts.presenceOfElementWait(speciesID);
        searchSpecies.clear();
        ts.presenceOfElementWait(searchCommonName);
        String cName = prop.getProperty("commonName");
        searchCommonName.sendKeys(cName);
        ts.presenceOfElementWait(speciesID);
        ts.presenceOfElementWait(speciesID);
        ts.presenceOfElementWait(referenceID);
        reference = referenceID.getText();
        searchCommonName.clear();
        ts.presenceOfElementWait(searchTheReference);
        searchTheReference.sendKeys(reference);
        ts.presenceOfElementWait(speciesID);
    }

    public void editTheSpecies() throws InterruptedException {
        ts.presenceOfElementWait(speciesID);
        speciesID.click();
        ts.presenceOfElementWait(selectRelatedTestDropDown);
        selectRelatedTestDropDown.click();
        ts.presenceOfElementWait(selectRelatedTestInput);
        String test = prop.getProperty("selectTest");
        Thread.sleep(2000);
        selectRelatedTestInput.sendKeys(Keys.ENTER);
        ts.presenceOfElementWait(addSpeciesSubmitButton);
        addSpeciesSubmitButton.click();
        ts.presenceOfElementWait(status);

    }

    public void deleteTheSpecies() {
        ts.presenceOfElementWait(speciesID);
        speciesID.click();
        ts.presenceOfElementWait(selectRelatedTestDropDown);
        ts.scrollPageDown();
        ts.presenceOfElementWait(deleteTheAddedSpecie);
        deleteTheAddedSpecie.click();
        ts.presenceOfElementWait(yesButtonForDeleteTheSpecie);
        yesButtonForDeleteTheSpecie.click();
        ts.presenceOfElementWait(status);
    }

    public void addAQuestion() {
        ts.presenceOfElementWait(questionsLink);
        questionsLink.click();
        ts.presenceOfElementWait(questionText);
        ts.presenceOfElementWait(addQuestionButton);
        addQuestionButton.click();
        ts.presenceOfElementWait(questionFormText);
        ts.presenceOfElementWait(questionInputField);
        String question = prop.getProperty("question");
        questionInputField.sendKeys(question + random);
        String responseType = prop.getProperty("responseType");
        driver.findElement(By.xpath("//label[text()='" + responseType + "']/../input")).click();
        try {
            ts.waitForTheElementVisibility(options, 5);
            ts.waitForTheElementVisibility(optionsInput, 5);
            String firstOption = prop.getProperty("option1");
            optionsInput.sendKeys(firstOption);
            ts.waitForTheElementVisibility(addOptionsButton, 10);
            addOptionsButton.click();
            ts.presenceOfElementWait(optionsInput);
            String secondOption = prop.getProperty("option2");
            optionsInput.sendKeys(secondOption);
            ts.waitForTheElementVisibility(addOptionsButton, 10);
            addOptionsButton.click();
            ts.waitForTheElementVisibility(optionsInput, 10);
            String thirdOption = prop.getProperty("option3");
            optionsInput.sendKeys(thirdOption);
            ts.waitForTheElementVisibility(addOptionsButton, 10);
            addOptionsButton.click();


        } catch (Exception e) {

        }
        ts.presenceOfElementWait(submitButtonForQuestions);
        submitButtonForQuestions.click();
        ts.presenceOfElementWait(status);

    }

    public void searchForTheAddedQuestion() {
        ts.presenceOfElementWait(searchBar);
        String question = prop.getProperty("question");
        searchBar.sendKeys(question + random);
        ts.presenceOfElementWait(addedQuestion);

    }

    public void editTheAddedQuestion() throws InterruptedException {
        ts.presenceOfElementWait(addedQuestion);
        Thread.sleep(4000);
        addedQuestion.click();
        ts.presenceOfElementWait(questionFormText);
        ts.presenceOfElementWait(questionInputField);
        questionInputField.clear();
        String question = prop.getProperty("editQuestion");
        questionInputField.sendKeys(question);
        ts.presenceOfElementWait(submitButtonForQuestions);
        submitButtonForQuestions.click();
        Thread.sleep(4000);
        ts.presenceOfElementWait(cancelIcon);
        cancelIcon.click();
        ts.presenceOfElementWait(searchBar);
        searchBar.sendKeys(question);
        ts.presenceOfElementWait(addedQuestion);

    }

    public void deleteTheAddedTest() throws InterruptedException {
        ts.presenceOfElementWait(addedQuestion);
        Thread.sleep(2000);
        addedQuestion.click();
        ts.presenceOfElementWait(questionFormText);
        ts.presenceOfElementWait(deleteTheAddedQuestion);
        deleteTheAddedQuestion.click();
        ts.presenceOfElementWait(yesButtonForDeleteTheQuestion);
        yesButtonForDeleteTheQuestion.click();
        ts.presenceOfElementWait(status);
    }

    public void addATest() {
        ts.presenceOfElementWait(testLink);
        testLink.click();
        ts.presenceOfElementWait(testText);
        ts.presenceOfElementWait(searchBar);
        ts.presenceOfElementWait(addTestButton);
        addTestButton.click();
        ts.presenceOfElementWait(addTestText);
        ts.presenceOfElementWait(testNameInputField);
        String testName = prop.getProperty("Name");
        testNameInputField.sendKeys(testName + random);
        ts.presenceOfElementWait(aliasInputField);
        String alias = prop.getProperty("alias");
        aliasInputField.sendKeys(alias + random);
        ts.presenceOfElementWait(descriptionField);
        String des = prop.getProperty("descriptionForTest");
        descriptionField.sendKeys(des);
        ts.presenceOfElementWait(labelToolInputField);
        String label = prop.getProperty("labelToolSet");
        labelToolInputField.sendKeys(label);
        ts.presenceOfElementWait(modelNameInputField);
        String test = prop.getProperty("modelNameOFTest");
        modelNameInputField.sendKeys(test);
        ts.presenceOfElementWait(saveButtonForTest);
        saveButtonForTest.click();
        ts.presenceOfElementWait(status);
    }

    public void searchTheAddedTest() {
        ts.presenceOfElementWait(searchBar);
        String name = prop.getProperty("Name");
        searchBar.sendKeys(name + random);
        ts.presenceOfElementWait(firstTestID);
        ts.presenceOfElementWait(firstTestName);

    }

    public void editTheTest() {
        ts.presenceOfElementWait(firstTestName);
        firstTestName.click();
        ts.presenceOfElementWait(defaultPriceInputField);
        defaultPriceInputField.clear();
        String price = prop.getProperty("defaultPrice");
        defaultPriceInputField.sendKeys(price);
        ts.presenceOfElementWait(saveButtonForTest);
        saveButtonForTest.click();
        ts.presenceOfElementWait(status);
    }

    public void addATestGroup() {
        ts.presenceOfElementWait(testGroupLink);
        testGroupLink.click();
        ts.presenceOfElementWait(testGroupText);
        ts.presenceOfElementWait(searchBar);
        ts.presenceOfElementWait(sortFilterDropDown);
        ts.presenceOfElementWait(addTestGroup);
        addTestGroup.click();
        ts.presenceOfElementWait(addTestGroupText);
        ts.presenceOfElementWait(testGroupNameTextInputField);
        String testGroupName = prop.getProperty("testGroupName");
        testGroupNameTextInputField.sendKeys(testGroupName + random);
        ts.presenceOfElementWait(addTestGroupSaveButton);
        addTestGroupSaveButton.click();
        ts.presenceOfElementWait(status);

    }

    static String testGroupId;

    public void searchForTheAddedTestGroup() throws InterruptedException {
        ts.presenceOfElementWait(searchBar);
        String testGroupName = prop.getProperty("testGroupName");
        searchBar.sendKeys(testGroupName + random);
        Thread.sleep(2000);
        ts.presenceOfElementWait(firstTestGroupName);
        ts.presenceOfElementWait(firstTestGroupID);
        testGroupId = firstTestGroupID.getText();
    }

    public void editTheTestGroup() throws InterruptedException {
        ts.presenceOfElementWait(firstTestGroupName);
        Thread.sleep(4000);
        firstTestGroupName.click();
        String testGroupName = prop.getProperty("editTestGroupName");
        ts.presenceOfElementWait(testGroupNameTextInputField);
        testGroupNameTextInputField.clear();
        testGroupNameTextInputField.sendKeys(testGroupName + random);
        ts.presenceOfElementWait(addTestGroupSaveButton);
        addTestGroupSaveButton.click();
        ts.presenceOfElementWait(status);
    }

    public void deleteTheAddedTestGroup() throws InterruptedException {
        ts.presenceOfElementWait(searchBar);
        ts.presenceOfElementWait(cancelIcon);
        cancelIcon.click();
        searchBar.sendKeys(testGroupId);
        ts.presenceOfElementWait(firstTestGroupName);
        Thread.sleep(2000);
        firstTestGroupName.click();
        ts.presenceOfElementWait(deleteTestGroupButton);
        deleteTestGroupButton.click();
        ts.presenceOfElementWait(yesButtonForDeleteTestGroup);
        yesButtonForDeleteTestGroup.click();
        ts.presenceOfElementWait(status);
    }

    public void checkForSortFilter() throws InterruptedException {
        ts.refreshTheWebPAge();
        Thread.sleep(4000);
        ts.presenceOfElementWait(sortFilterDropDown);
        sortFilterDropDown.click();
        int size = sortingFilterDropDownElements.size();
        for (int i = 0; i < size; i++) {
            sortingFilterDropDownElements.get(i).click();
            ts.presenceOfElementWait(firstTestGroupID);
            ts.presenceOfElementWait(sortFilterDropDown);
            sortFilterDropDown.click();
        }
    }

    public void addAItem() {
        ts.presenceOfElementWait(itemsLink);
        itemsLink.click();
        ts.presenceOfElementWait(itemText);
        ts.presenceOfElementWait(itemSortingFilterDropDown);
        ts.presenceOfElementWait(addItemButton);
        addItemButton.click();
        ts.presenceOfElementWait(addItemText);
        ts.presenceOfElementWait(itemNameInputField);
        String itemName = prop.getProperty("itemName");
        itemNameInputField.sendKeys(itemName);
        ts.presenceOfElementWait(itemUnitInputField);
        String itemUnit = prop.getProperty("itemUnit");
        itemUnitInputField.sendKeys(itemUnit);
        ts.presenceOfElementWait(itemVendorNameInputField);
        String vendorName = prop.getProperty("itemVendorName");
        itemVendorNameInputField.sendKeys(vendorName);
        ts.presenceOfElementWait(itemURLInputField);
        String itemURL = prop.getProperty("itemURL");
        itemURLInputField.sendKeys(itemURL);
        ts.presenceOfElementWait(itemPricingInputField);
        String itemPrice = prop.getProperty("itemPricing");
        itemPricingInputField.sendKeys(itemPrice);
        ts.presenceOfElementWait(itemInventoryInputField);
        String itemInventory = prop.getProperty("itemInventory");
        itemInventoryInputField.sendKeys(itemInventory);
        ts.presenceOfElementWait(itemThresholdInputField);
        String itemThreshold = prop.getProperty("itemThreshold");
        itemThresholdInputField.sendKeys(itemThreshold);
        ts.presenceOfElementWait(addItemSubmitButton);
        addItemSubmitButton.click();
        ts.presenceOfElementWait(status);
    }

    static String itemID;

    public void searchTheAddedItem() {
        ts.presenceOfElementWait(searchBar);
        String itemName = prop.getProperty("itemName");
        searchBar.sendKeys(itemName);
        ts.presenceOfElementWait(firstItemID);
        itemID = firstItemID.getText();
    }

    public void editTheItem() throws InterruptedException {
        ts.presenceOfElementWait(firstItemName);
        Thread.sleep(2000);
        firstItemName.click();
        ts.presenceOfElementWait(itemUnitInputField);
        itemUnitInputField.clear();
        String itemUnit = prop.getProperty("editItemUnit");
        itemUnitInputField.sendKeys(itemUnit);
//        ts.presenceOfElementWait(imageInputField);
//        String imagePAth=prop.getProperty("image_path");
//        imageInputField.sendKeys(imagePAth);
        ts.presenceOfElementWait(addItemSubmitButton);
        addItemSubmitButton.click();

    }

    public void deleteTheAddedItem() {
        ts.presenceOfElementWait(cancelIcon);
        cancelIcon.click();
        searchBar.sendKeys(itemID);
        ts.presenceOfElementWait(firstItemName);
        firstItemName.click();
        ts.presenceOfElementWait(deleteTheItemButton);
        deleteTheItemButton.click();
        ts.presenceOfElementWait(yesButtonForDeletingItem);
        yesButtonForDeletingItem.click();
        ts.presenceOfElementWait(status);
    }

    public void checkForItemSortingFilter() {
        ts.refreshTheWebPAge();
        ts.presenceOfElementWait(itemSortingFilterDropDown);
        itemSortingFilterDropDown.click();
        int size = sortingFilterDropDownElements.size();
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            System.out.println(i);
            sortingFilterDropDownElements.get(i).click();
            ts.presenceOfElementWait(itemSortingFilterDropDown);
            itemSortingFilterDropDown.click();
            ts.presenceOfElementWait(firstItemID);
        }
    }

    public void addABundle() throws InterruptedException {
        ts.waitForTheElementVisibility(bundleLink, 10);
        bundleLink.click();
        ts.presenceOfElementWait(bundleText);
        ts.presenceOfElementWait(searchBar);
        ts.presenceOfElementWait(addBundleButton);
        addBundleButton.click();
        ts.presenceOfElementWait(addBundleText);
        ts.presenceOfElementWait(bundleNameInputField);
        String bundleName = prop.getProperty("bundleName");
        bundleNameInputField.sendKeys(bundleName+random);
        ts.presenceOfElementWait(addReferenceTestToBundleDropDown);
        addReferenceTestToBundleDropDown.click();
        Thread.sleep(4000);
        ts.presenceOfElementWait(addReferenceTestToBundleInputField);
        String referenceTestName = prop.getProperty("addReferenceTest");
        String secondReferenceTest = prop.getProperty("addSecondReferenceTest");
        int size = allReferenceTests.size();
        for (int i = 0; i < size; i++)
        {

            if (allReferenceTests.get(i).getText().equalsIgnoreCase(referenceTestName)) {
                allReferenceTests.get(i).click();
                ts.presenceOfElementWait(referenceTestAddButton);
                referenceTestAddButton.click();
                ts.presenceOfElementWait(cancelButton);
                cancelButton.click();
                ts.presenceOfElementWait(addReferenceTestToBundleDropDown);
                addReferenceTestToBundleDropDown.click();
                ts.presenceOfElementWait(addReferenceTestToBundleInputField);

            } else if (allReferenceTests.get(i).getText().equalsIgnoreCase(secondReferenceTest)) {
                allReferenceTests.get(i).click();
                ts.presenceOfElementWait(referenceTestAddButton);
                referenceTestAddButton.click();
                break;
            }


        }
        ts.presenceOfElementWait(addBundleSubmitButton);
        addBundleSubmitButton.click();
        ts.presenceOfElementWait(status);

    }

    public void searchTheAddedBundle() {
        ts.presenceOfElementWait(searchBar);
        String bundleName = prop.getProperty("bundleName");
        searchBar.sendKeys(bundleName);
        ts.presenceOfElementWait(firstBundleName);

    }

    public void editTheBundle() throws InterruptedException {
        Thread.sleep(2000);
        ts.presenceOfElementWait(firstBundleName);
        Thread.sleep(2000);
        firstBundleName.click();
        ts.presenceOfElementWait(addReferenceTestToBundleDropDown);
        addReferenceTestToBundleDropDown.click();
        Thread.sleep(4000);
        ts.presenceOfElementWait(addReferenceTestToBundleInputField);
        String referenceTestName = prop.getProperty("editReferenceTest");
        int size = allReferenceTests.size();
        for (int i = 0; i < size; i++) {

            if (allReferenceTests.get(i).getText().equalsIgnoreCase(referenceTestName)) {
                allReferenceTests.get(i).click();
                ts.presenceOfElementWait(referenceTestAddButton);
                referenceTestAddButton.click();
                ts.presenceOfElementWait(cancelButton);
                cancelButton.click();
                ts.presenceOfElementWait(addReferenceTestToBundleDropDown);
                addReferenceTestToBundleDropDown.click();
                ts.presenceOfElementWait(addReferenceTestToBundleInputField);
                break;

            }
        }
        ts.presenceOfElementWait(addBundleSubmitButton);
        addBundleSubmitButton.click();
        ts.presenceOfElementWait(status);

    }

    public void deleteTheBundle()
    {
        ts.presenceOfElementWait(firstBundleName);
        firstBundleName.click();
        ts.presenceOfElementWait(addBundleText);
        ts.presenceOfElementWait(deleteTheAddedBundleButton);
        deleteTheAddedBundleButton.click();
        ts.presenceOfElementWait(yesButtonForDeletingBundle);
        yesButtonForDeletingBundle.click();
        ts.presenceOfElementWait(status);
    }

    public void bundleSortingFilter()
    {
        ts.refreshTheWebPAge();
        ts.presenceOfElementWait(upDownArrow);
        upDownArrow.click();
        ts.presenceOfElementWait(firstBundleName);
        ts.presenceOfElementWait(idText);
        idText.click();
        ts.presenceOfElementWait(firstBundleName);
        ts.presenceOfElementWait(upDownArrow);
        upDownArrow.click();
        ts.presenceOfElementWait(firstBundleName);
    }

    public void addAVolumeTier() throws InterruptedException {
        ts.presenceOfElementWait(volumeTierLink);
        volumeTierLink.click();
        ts.presenceOfElementWait(volumeTierText);
        ts.presenceOfElementWait(addVolumeButton);
        addVolumeButton.click();
        ts.presenceOfElementWait(volumeTierNameInputField);
        String volumeName=prop.getProperty("volumeTierName");
        volumeTierNameInputField.sendKeys(volumeName+random);
        ts.presenceOfElementWait(minOrderInputField);
        String minOrder=prop.getProperty("volumeTierMinOrder");
        minOrderInputField.sendKeys(minOrder);
        ts.presenceOfElementWait(maxOrderInputField);
        String maxOrder=prop.getProperty("volumeTierMaxOrder");
        maxOrderInputField.sendKeys(maxOrder);
        ts.presenceOfElementWait(referenceBundleDropDown);
        referenceBundleDropDown.click();
        Thread.sleep(4000);
        ts.presenceOfElementWait(referenceBundleInputField);
        int size=allReferenceBundle.size();
        for(int i=0; i<size; i++)
        {
            allReferenceBundle.get(i).click();
            break;
        }
        ts.presenceOfElementWait(addVolumeSubmitButton);
        addVolumeSubmitButton.click();
        ts.presenceOfElementWait(status);
    }

    public void searchTheAddedTier()
    {
        ts.presenceOfElementWait(searchBar);
        String tierName=prop.getProperty("volumeTierName");
        searchBar.sendKeys(tierName+random);
        ts.presenceOfElementWait(firstTierName);

    }

    public void editTheTier()
    {
        firstTierName.click();
        ts.presenceOfElementWait(minOrderInputField);
        minOrderInputField.clear();
        String minOrder=prop.getProperty("tierMinOrder");
        minOrderInputField.sendKeys(minOrder);
        ts.presenceOfElementWait(maxOrderInputField);
        maxOrderInputField.clear();
        String maxOrder=prop.getProperty("tierMaxOrder");
        maxOrderInputField.sendKeys(maxOrder);
        ts.presenceOfElementWait(addVolumeSubmitButton);
        addVolumeSubmitButton.click();
    }

    public void deleteTheTier()
    {
        ts.presenceOfElementWait(firstTierName);
        firstTierName.click();
        ts.presenceOfElementWait(deleteVolumeTierButton);
        deleteVolumeTierButton.click();
        ts.presenceOfElementWait(yesButtonForDeletingVolumeTier);
        yesButtonForDeletingVolumeTier.click();
        ts.presenceOfElementWait(status);
    }

    public void addAClinicalTemplate()
    {
        ts.presenceOfElementWait(clinicalTemplateLink);
        clinicalTemplateLink.click();
        ts.presenceOfElementWait(addClinicalTemplateButton);
        ts.presenceOfElementWait(searchBar);
        addClinicalTemplateButton.click();
        ts.presenceOfElementWait(templateNameInputField);
        String templateName=prop.getProperty("templateName");
        templateNameInputField.sendKeys(templateName);
        ts.presenceOfElementWait(templateTypeDropDown);
        templateTypeDropDown.click();
        ts.presenceOfElementWait(templateNameInputField);
        String templateTypeName=prop.getProperty("templateType");
        int size=allTypes.size();
        for(int i=0; i<size; i++)
        {
            if(allTypes.get(i).getText().equalsIgnoreCase(templateTypeName))
            {
                allTypes.get(i).click();
                break;
            }
        }
        ts.presenceOfElementWait(templateBodyInputField);
        String templateBody=prop.getProperty("templateBody");
        templateBodyInputField.sendKeys(templateBody);
        ts.presenceOfElementWait(templateSubmitButton);
        templateSubmitButton.click();
        ts.presenceOfElementWait(status);
    }

    public void searchTheClinicalTemplate()
    {
        ts.presenceOfElementWait(searchBar);
        String templateName=prop.getProperty("templateName");
        searchBar.sendKeys(templateName);
        ts.presenceOfElementWait(firstClinicalTemplateName);
    }

    public void editTheClinicalTemplate()
    {
        ts.presenceOfElementWait(firstClinicalTemplateName);
        firstClinicalTemplateName.click();
        ts.presenceOfElementWait(templateDescriptionInputTextField);
        String description=prop.getProperty("templateDescription");
        templateDescriptionInputTextField.sendKeys(description);
        ts.presenceOfElementWait(templateSubmitButton);
        templateSubmitButton.click();
        ts.presenceOfElementWait(status);
    }

    public void deleteTheClinicalTemplate()
    {
        ts.presenceOfElementWait(firstClinicalTemplateName);
        firstClinicalTemplateName.click();
        ts.presenceOfElementWait(deleteClinicalTemplateButton);
        deleteClinicalTemplateButton.click();
        ts.presenceOfElementWait(yesButtonForDeletingClinicalTemplate);
        yesButtonForDeletingClinicalTemplate.click();
        ts.presenceOfElementWait(status);
    }

    public void addAConditions() throws InterruptedException {
        ts.presenceOfElementWait(itemsLink);
        ts.scrollIntoView(conditionsLink);
        ts.presenceOfElementWait(conditionsLink);
        conditionsLink.click();
        ts.presenceOfElementWait(conditionsText);
        ts.presenceOfElementWait(searchBar);
        ts.presenceOfElementWait(addConditionsButton);
        addConditionsButton.click();
        ts.presenceOfElementWait(conditionsFormText);
        ts.presenceOfElementWait(referenceTestDropDown);
        referenceTestDropDown.click();
        Thread.sleep(4000);
        String refTest=prop.getProperty("referenceTest");
        ts.presenceOfElementWait(referenceTestInputField);
        int size=allReferenceTests.size();
        for(int i=0; i<size; i++)
        {
            if(allReferenceTests.get(i).getText().equalsIgnoreCase(refTest))
            {
                allReferenceTests.get(i).click();
                break;
            }
        }
        ts.presenceOfElementWait(conditionsTextInputField);
        String conditions=prop.getProperty("conditionsText");
        conditionsTextInputField.sendKeys(conditions+random);
        ts.presenceOfElementWait(addConditionSubmitButton);
        addConditionSubmitButton.click();
        ts.presenceOfElementWait(status);
    }

    public void searchTheAddedConditions()
    {
        ts.presenceOfElementWait(searchBar);
        String refTest=prop.getProperty("referenceTest");
        searchBar.sendKeys(refTest);
        ts.presenceOfElementWait(firstCondition);
    }

    public void editTheConditions()
    {
        ts.presenceOfElementWait(firstCondition);
        firstCondition.click();
        ts.presenceOfElementWait(conditionsFormText);
        ts.presenceOfElementWait(conditionsTextInputField);
        conditionsTextInputField.clear();
        String conditionText=prop.getProperty("editConditionText");
        conditionsTextInputField.sendKeys(conditionText);
        ts.presenceOfElementWait(addConditionSubmitButton);
        addConditionSubmitButton.click();
        ts.presenceOfElementWait(status);
    }

    public void deleteTheAddedConditions()
    {
        ts.presenceOfElementWait(firstCondition);
        firstCondition.click();
        ts.presenceOfElementWait(deleteConditionsButton);
        deleteConditionsButton.click();
        ts.presenceOfElementWait(yesButtonForDeletingConditions);
        yesButtonForDeletingConditions.click();
        ts.presenceOfElementWait(status);
    }

    public void filterTheCondition()
    {
        ts.refreshTheWebPAge();
        ts.presenceOfElementWait(downArrow);
        downArrow.click();
        ts.presenceOfElementWait(firstCondition);
        ts.presenceOfElementWait(idText);
        idText.click();
        ts.presenceOfElementWait(firstCondition);
        ts.presenceOfElementWait(upDownArrow);
        upDownArrow.click();
        ts.presenceOfElementWait(firstCondition);
    }

    public void addATask() throws InterruptedException {
        ts.presenceOfElementWait(itemsLink);
        ts.scrollIntoView(tasksLink);
        ts.presenceOfElementWait(tasksLink);
        Thread.sleep(1000);
        tasksLink.click();
        ts.presenceOfElementWait(addNewTaskButton);
        addNewTaskButton.click();
        ts.presenceOfElementWait(tasksForm);
        ts.presenceOfElementWait(tasksNameInputField);
        String taskName= prop.getProperty("taskName");
        tasksNameInputField.sendKeys(taskName+random);
        ts.presenceOfElementWait(taskAvailableDropDown);
        taskAvailableDropDown.click();
        Thread.sleep(2000);
        ts.presenceOfElementWait(taskAvailableInput);
        String taskAvailable= prop.getProperty("taskAvailable");
        int size=allElements.size();
        System.out.println(allElements);
        for(int i=0; i<size; i++)
        {

            if(allElements.get(i).getText().equalsIgnoreCase(taskAvailable))
            {
                allElements.get(i).click();
                break;
            }
        }
        ts.presenceOfElementWait(refTestDropDown);
        refTestDropDown.click();
        Thread.sleep(2000);
        ts.presenceOfElementWait(refTestInputField);
        String refTest=prop.getProperty("taskReferenceTest");
        for(int i=0; i<size; i++)
        {
            if(allElements.get(i).getText().equalsIgnoreCase(refTest))
            {
                allElements.get(i).click();
                break;
            }
        }
        ts.presenceOfElementWait(selectStatusDropDown);
        selectStatusDropDown.click();
        Thread.sleep(2000);
        String taskStatus=prop.getProperty("taskStatus");
        ts.presenceOfElementWait(selectStatusInput);
        for(int i=0; i<size; i++)
        {
            if(allElements.get(i).getText().equalsIgnoreCase(taskStatus))
            {
                allElements.get(i).click();
                break;
            }
        }
        ts.presenceOfElementWait(addTaskSubmitButton);
        addTaskSubmitButton.click();
        ts.presenceOfElementWait(status);

    }

    public void searchTheTasks()
    {
        ts.presenceOfElementWait(searchBar);
        String taskName=prop.getProperty("taskName");
        searchBar.sendKeys(taskName+random);
        ts.presenceOfElementWait(firstTaskName);

    }

    public void editTheTask() throws InterruptedException {
        Thread.sleep(2000);
        ts.presenceOfElementWait(firstTaskName);
        firstTaskName.click();
        Thread.sleep(2000);
        ts.presenceOfElementWait(addMoreLink);
        addMoreLink.click();
        ts.presenceOfElementWait(secondRefTestDropDown);
        secondRefTestDropDown.click();
        Thread.sleep(2000);
        ts.presenceOfElementWait(secondRefTestInputField);
        String refTest=prop.getProperty("editRefTest");
        int size=allElements.size();
        for(int i=0;i <size; i++)
        {
            if(allElements.get(i).getText().equalsIgnoreCase(refTest))
            {
                allElements.get(i).click();
                break;
            }
        }
        ts.presenceOfElementWait(secondSelectStatusDropDown);
        secondSelectStatusDropDown.click();
        Thread.sleep(2000);
        ts.presenceOfElementWait(secondSelectStatusInputField);
        String taskStatus=prop.getProperty("editTaskStatus");
        for(int i=0;i <size; i++)
        {
            if(allElements.get(i).getText().equalsIgnoreCase(taskStatus))
            {
                allElements.get(i).click();
                break;
            }
        }
        ts.presenceOfElementWait(addTaskSubmitButton);
        addTaskSubmitButton.click();
        ts.presenceOfElementWait(status);
    }

    public void deleteTheTasks()
    {
        ts.presenceOfElementWait(firstTaskName);
        firstTaskName.click();
        ts.presenceOfElementWait(deleteTaskButton);
        deleteTaskButton.click();
        ts.presenceOfElementWait(yesButtonForDeletingTask);
        yesButtonForDeletingTask.click();
        ts.presenceOfElementWait(status);
    }
}
