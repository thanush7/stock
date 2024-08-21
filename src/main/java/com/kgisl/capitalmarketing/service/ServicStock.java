package com.kgisl.capitalmarketing.service;

import java.io.FileReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import com.kgisl.capitalmarketing.DatabaseConnection;
import com.kgisl.capitalmarketing.pojo.Stock;
import com.kgisl.capitalmarketing.pojo.Template;
// import com.opencsv.bean.CsvToBeanBuilder;

public class ServicStock {
    //csv to list
    // public List<Stock> csvToObject(String filepath) throws Exception {
    //     @SuppressWarnings({ "rawtypes", "unchecked" })
    //     List<Stock> list = new CsvToBeanBuilder(new FileReader(filepath)).withType(Stock.class).build().parse();
    //     return list;
    // }

    //insert data into database
    // public int insert() throws Exception {
    //     ServicStock ser = new ServicStock();
    //     String filePath = "file.csv";
    //     List<Stock> list = ser.csvToObject(filePath);

    //     try (Connection conn = DatabaseConnection.getConnection()) {
    //         String insertQuery = "insert into stock values(?,?,?,?,?)";
    //         PreparedStatement ps1 = conn.prepareStatement(insertQuery);
    //         list.forEach(x -> {
    //             try {
    //                 ps1.setInt(1, x.getStockId());
    //                 ps1.setString(2, x.getSymbol());
    //                 ps1.setString(3, x.getCompanyName());
    //                 ps1.setBigDecimal(4, x.getCurrentprice());
    //                 ps1.setDate(5, x.getLastUpdate());
    //                 ps1.addBatch();
    //             } catch (SQLException e) {
    //                 e.printStackTrace();
    //             }
    //         });
    //         int[] updated = ps1.executeBatch();
    //         return updated.length;
    //     }
    // }
    //to read the data from database and store in list
    public List<Template> read(){
        List<Template> list=new ArrayList<>();
        try(Connection conn=DatabaseConnection.getConnection())
        {
            String q1="select * from stock";
            PreparedStatement ps1=conn.prepareStatement(q1);
            ResultSet res=ps1.executeQuery();
            while(res.next()){
                int id=res.getInt(1);
                String sym=res.getString(2);
                String companyName=res.getString(3);
                BigDecimal currentPrice=res.getBigDecimal(4);
                Date last=res.getDate(5);
                list.add(new Template(id,sym,companyName,currentPrice,last));

            }
        }
        catch(Exception e){
        }
        return list;
    }
}
