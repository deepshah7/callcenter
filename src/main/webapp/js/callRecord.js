$(document).ready(function()
    {
        $("#callRecordsTable").tablesorter(
            {
                sortList: [[0,0]],
                headers:{
                    6:{sorter:false},
                    7:{sorter:false}
                }
            }

        );
    }
);

function CallRecords(data, contextRoot) {
    this.data = data;
    this.contextRoot = contextRoot;
    this.callRecordRow =  "<tr class='callRecord'>" +
            "<td>#calltime#</td>" +
            "<td>#callerid#</td>" +
            "<td>#displayinfo#</td>" +
            "<td>#calledId#</td>" +
            "<td>#targetid#</td>" +
            "<td>#ipaddress#</td>" +
            "<td><span><a href='#contextRoot#callrecord/#callid#'><img src='#contextRoot#static/images/show.png' title='Show Call Record' /></a></span></td>" +
            "<td><span><a href='#contextRoot#wavefileplay/#callid#'><img src='#contextRoot#static/images/play.png' title='Play' /></a></span></td>" +
            "</tr>";

    this.createRows = function() {
        this.removeExistingRows();
        this.createNewRows();
    };

    this.removeExistingRows = function() {
        $(".callRecord").remove();
    };

    this.createNewRows = function() {
        for(var i=0; i < this.data.length; i++) {
            $("#callRecordsTable").append(this.callRecordRow
                    .replace(/#callid#/g, this.data[i].id)
                    .replace("#callerid#", this.data[i].callerId)
                    .replace(/#contextRoot#/g, this.contextRoot)
                    .replace("#displayinfo#", this.data[i].displayInfo)
                    .replace("#calltime#", this.data[i].formattedCallTime)
                    .replace("#calledId#", this.data[i].calledId)
                    .replace("#targetid#", this.data[i].targetId)
                    .replace("#ipaddress#", this.data[i].ipAddress? this.data[i].ipAddress : "")
                    );

        }
    };
}

function SearchCriteria() {
    this.update = function() {
        var formValue = $("#searchForm").serialize();
        var formValues = formValue.split("&");
        var searchCriteria = "";
        for(var i=0; i < formValues.length; i++) {
            var actualValues = formValues[i].split("=");
            if(actualValues[1] == "") continue;
            if(searchCriteria != "") searchCriteria = searchCriteria + " and ";
            searchCriteria = searchCriteria + actualValues[0] + " = " + actualValues[1]
        }
        $("#currentCriteria").html(searchCriteria);
    };
}