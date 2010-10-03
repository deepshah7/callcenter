function CallRecords(data, contextRoot) {
    this.data = data;
    this.contextRoot = contextRoot;
    this.callRecordRow =  "<tr class='callRecord'>" +
            "<td>#callid#</td>" +
            "<td>#callerid#</td>" +
            "<td>#displayinfo#</td>" +
            "<td>#calltime#</td>" +
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
                    .replace("#calltime#", this.data[i].callTime? this.data[i].callTime : "")
                    .replace("#calledId#", this.data[i].calledId)
                    .replace("#targetid#", this.data[i].targetId)
                    .replace("#ipaddress#", this.data[i].ipAddress? this.data[i].ipAddress : "")
                    );

        }
    };
}