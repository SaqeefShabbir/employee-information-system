package com.conurets.EmployeeInformationSystem.dto;

public class OrderByDTO
{
    private String column;

    private String sortingType;

    public OrderByDTO(String column, String sortingType)
    {
        this.column = column;
        this.sortingType = sortingType;
    }

    public String getColumn()
    {
        return column;
    }

    public void setColumn(String column)
    {
        this.column = column;
    }

    public String getSortingType()
    {
        return sortingType;
    }

    public void setSortingType(String sortingType)
    {
        this.sortingType = sortingType;
    }
}
