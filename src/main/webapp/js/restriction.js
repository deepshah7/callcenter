function Restriction(parentSelector, fields) {
    this.parentSelector = parentSelector;
    this.fields = fields;
    this.create = function() {
        this.createHTML();
        this.setupAutoComplete();
        this.setupRemoveAction();
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
    };

    this.setupRemoveAction = function() {
        var currentIndex = this.index;
        $("#removeRestriction_" + this.index).click(function() {
            $("#restriction_container_" + currentIndex).remove();
        });
    };
}

Restriction.currentRestrictionIndex = -1;
Restriction.html =
        "<div id='restriction_container_{restriction_index}'>"
          + "<div id='restriction_{restriction_index}'>"
              + "<label for='fieldDescription_{restriction_index}' class='floatLeft smallLabel'>Restriction</label>"
              + "<input name='restrictionList[{restriction_index}].field.description' type='text' id='fieldDescription_{restriction_index}' class='smallInput floatLeft marginLeft'/>"
              + "<input name='restrictionList[{restriction_index}].field.id' type='hidden' id='fieldId_{restriction_index}' />"
              + "<select name='restrictionList[{restriction_index}].type' class='marginLeft'><option>IN</option><option>BETWEEN</option></select>"
              + "<input name='restrictionList[{restriction_index}].comaSeperatedValues' class='marginLeft' type='text' />"
              + "<input class='marginLeft' type='button' id='removeRestriction_{restriction_index}' value='Remove'/>"
          + "</div>"
          + "<div class='clearBoth'><br /></div>"
      + "</div>";
