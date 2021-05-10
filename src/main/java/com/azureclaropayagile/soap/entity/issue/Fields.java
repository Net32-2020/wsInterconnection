package com.azureclaropayagile.soap.entity.issue;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fields {
	 @JsonProperty("System.Id") 
	    public int systemId;
	    @JsonProperty("System.AreaId") 
	    public int systemAreaId;
	    @JsonProperty("System.AreaPath") 
	    public String systemAreaPath;
	    @JsonProperty("System.TeamProject") 
	    public String systemTeamProject;
	    @JsonProperty("System.NodeName") 
	    public String systemNodeName;
	    @JsonProperty("System.AreaLevel1") 
	    public String systemAreaLevel1;
	    @JsonProperty("System.Rev") 
	    public int systemRev;
	    @JsonProperty("System.AuthorizedDate") 
	    public Date systemAuthorizedDate;
	    @JsonProperty("System.RevisedDate") 
	    public Date systemRevisedDate;
	    @JsonProperty("System.IterationId") 
	    public int systemIterationId;
	    @JsonProperty("System.IterationPath") 
	    public String systemIterationPath;
	    @JsonProperty("System.IterationLevel1") 
	    public String systemIterationLevel1;
	    @JsonProperty("System.WorkItemType") 
	    public String systemWorkItemType;
	    @JsonProperty("System.State") 
	    public String systemState;
	    @JsonProperty("System.Reason") 
	    public String systemReason;
	    @JsonProperty("System.CreatedDate") 
	    public Date systemCreatedDate;
	    @JsonProperty("System.CreatedBy") 
	    public SystemCreatedBy systemCreatedBy;
	    @JsonProperty("System.ChangedDate") 
	    public Date systemChangedDate;
	    @JsonProperty("System.ChangedBy") 
	    public SystemChangedBy systemChangedBy;
	    @JsonProperty("System.AuthorizedAs") 
	    public SystemAuthorizedAs systemAuthorizedAs;
	    @JsonProperty("System.PersonId") 
	    public int systemPersonId;
	    @JsonProperty("System.Watermark") 
	    public int systemWatermark;
	    @JsonProperty("System.CommentCount") 
	    public int systemCommentCount;
	    @JsonProperty("System.Title") 
	    public String systemTitle;
	    @JsonProperty("System.BoardColumn") 
	    public String systemBoardColumn;
	    @JsonProperty("System.BoardColumnDone") 
	    public boolean systemBoardColumnDone;
	    @JsonProperty("Microsoft.VSTS.Common.StateChangeDate") 
	    public Date microsoftVSTSCommonStateChangeDate;
	    @JsonProperty("Microsoft.VSTS.Common.ActivatedDate") 
	    public Date microsoftVSTSCommonActivatedDate;
	    @JsonProperty("Microsoft.VSTS.Common.ActivatedBy") 
	    public MicrosoftVSTSCommonActivatedBy microsoftVSTSCommonActivatedBy;
	    @JsonProperty("Microsoft.VSTS.Common.ClosedDate") 
	    public Date microsoftVSTSCommonClosedDate;
	    @JsonProperty("Microsoft.VSTS.Common.ClosedBy") 
	    public MicrosoftVSTSCommonClosedBy microsoftVSTSCommonClosedBy;
	    @JsonProperty("Microsoft.VSTS.Common.Priority") 
	    public int microsoftVSTSCommonPriority;
	    @JsonProperty("WEF_E2962187602845258EAB99AE24387667_System.ExtensionMarker") 
	    public boolean wEFE2962187602845258EAB99AE24387667SystemExtensionMarker;
	    @JsonProperty("WEF_E2962187602845258EAB99AE24387667_Kanban.Column") 
	    public String wEFE2962187602845258EAB99AE24387667KanbanColumn;
	    @JsonProperty("WEF_E2962187602845258EAB99AE24387667_Kanban.Column.Done") 
	    public boolean wEFE2962187602845258EAB99AE24387667KanbanColumnDone;
	    @JsonProperty("Custom.Id_nivel_dos") 
	    public String customIdNivelDos;
	    @JsonProperty("System.Description") 
	    public String systemDescription;
	    @JsonProperty("System.History") 
	    public String systemHistory;
	    public String href;
}
