function Restriction(parentSelector, fields) {
    this.parentSelector = parentSelector;
    this.fields = fields;
    this.create = function() {
        this.createHTML();
        this.setupAutoComplete();
    };

    this.createHTML = function() {
        Restriction.currentRestrictionIndex = Restriction.currentRestrictionIndex + 1;
        this.index = Restriction.currentRestrictionIndex;
        $(this.parentSelector).append(Restriction.html.replace(/{restriction_index}/g,
                this.index));
    };

    this.setupAutoComplete = function() {
        this.fieldDescriptionSelector = "#fieldDescription_" + this.index;
        $(this.fieldDescriptionSelector).autocomplete({
            source: this.fields
        });
    }
}

Restriction.currentRestrictionIndex = -1;
Restriction.html =
        "<div id='restriction_{restriction_index}'>"
      + "<label for='fieldDescription_{restriction_index}' class='floatLeft smallLabel'>Restriction</label>"
      + "<input name='restrictionList[{restriction_index}].field.description' type='text' id='fieldDescription_{restriction_index}' class='smallInput floatLeft marginLeft'/>"
      + "<input name='restrictionList[{restriction_index}].field.id' type='hidden' id='fieldId_{restriction_index}' />"
      + "</div>";
