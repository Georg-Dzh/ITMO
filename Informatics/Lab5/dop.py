import polars as pl

df = pl.read_excel("ЛБ5.xlsx",has_header=False)
df = df.select(pl.all().cast(pl.Utf8))
print("A =", df[0, 2])
print("C =", df[1, 2])
table = df[2:14, :25].drop("column_5")

with pl.Config(tbl_formatting="UTF8_FULL_CONDENSED", tbl_rows=-1,tbl_cols=-1, tbl_width_chars=1000, tbl_hide_dataframe_shape=True):
    print(table)