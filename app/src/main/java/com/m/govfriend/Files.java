package com.m.govfriend;

import java.util.ArrayList;

/**
 * Created by User on 01-Mar-18.
 */

public class Files {

    String file_date,file_desc;
    String file_name,file_status;
    static class FileOfficials
    {
        String name,num;
    }
    ArrayList<FileOfficials> fileOfficials=new ArrayList<FileOfficials>();
    Files(String file_date,String file_desc,String file_name,String file_status)
    {
        this.file_date=file_date;
        this.file_desc=file_desc;
        this.file_name=file_name;
        this.file_status=file_status;
    }
}
