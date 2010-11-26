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
        var fieldDescriptionSelector = "#fieldDescription_" + this.index;
        var fieldIdSelector = "#fieldId_" + this.index;
        $(fieldDescriptionSelector).autocomplete({
            source: this.fields,
            select: function(event, ui) {
                $(fieldDescriptionSelector).val(ui.item.label);
                $(fieldIdSelector).val(ui.item.id);
                return false;
            }
        });
    }
}

Restriction.currentRestrictionIndex = -1;
Restriction.html =
        "<div id='restriction_{restriction_index}'>"
      + "<label for='fieldDescription_{restriction_index}' class='floatLeft smallLabel'>Restriction</label>"
      + "<input name='restrictionList[{restriction_index}].field.description' type='text' id='fieldDescription_{restriction_index}' class='smallInput floatLeft marginLeft'/>"
      + "<input name='restrictionList[{restriction_index}].field.id' type='hidden' id='fieldId_{restriction_index}' />"
      + "</div>"
      + "<div class='clearBoth'><br /></div>";
