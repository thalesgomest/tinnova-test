package com.tinnova;

public class Election {

  private final double totalVoters;
  private final double validVotes;
  private final double blankVotes;
  private final double nullVotes;
  
  public Election(double validVotes, double blankVotes, double nullVotes) {
    this.validVotes = validVotes;
    this.blankVotes = blankVotes;
    this.nullVotes = nullVotes;

    this.totalVoters = validVotes + blankVotes + nullVotes;
  }

  public double getPercentageValidVotes() {
    return (validVotes / totalVoters) * 100;
  }
  public double getPercentageBlankVotes() {
    return (blankVotes / totalVoters) * 100;
  }
  public double getPercentageNullVotes() {
    return (nullVotes / totalVoters) * 100;
  }
  
}
