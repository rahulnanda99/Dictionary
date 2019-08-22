package com.example.dictionary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.net.IDN;

public class mydatabasehandler extends SQLiteOpenHelper
{
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="mydatabase";
    public static final String TABLE_NAME="WORDS_MEANING";
    public static final String WORD="word";
    public static final String MEANING="meaning";
    public static final String DESCRIPTION="description";

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param  The database.
     */
    public mydatabasehandler(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String query="CREATE TABLE " + TABLE_NAME + "(" + WORD + " TEXT PRIMARY KEY," + MEANING + " TEXT," + DESCRIPTION + " TEXT);";
        db.execSQL(query);

    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     *
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
    public void addword(record record)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(WORD,record.getWord());
        values.put(MEANING,record.getMeaning());
        values.put(DESCRIPTION,record.getDescription());
        db.insert(TABLE_NAME,null,values);
    }
    public record getmeaning(String word)
    {
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME,new String[]{WORD,MEANING,DESCRIPTION}, WORD + "=?",new String[]{word},null,null,null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
        }
        return new record(cursor.getString(0),cursor.getString(1),cursor.getString(2));


    }
    public Cursor getword()
    {
        SQLiteDatabase db=getReadableDatabase();
        String Query="SELECT WORD FROM "+TABLE_NAME;
        Cursor cr=db.rawQuery(Query,null);
        return cr;
    }
}
