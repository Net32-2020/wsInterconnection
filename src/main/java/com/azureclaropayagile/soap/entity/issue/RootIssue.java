package com.azureclaropayagile.soap.entity.issue;

import java.util.List;

public class RootIssue {
	public int id;
    public int rev;
    public Fields fields;
    public List<Relation> relations;
    public CommentVersionRef commentVersionRef;
    public Links _links;
    public String url;
}
