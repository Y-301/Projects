attach(data)
#NOTES
#1) Data.csv = raw/original data
#2) houseData = Data.csv - 12 unused columns
#3) new_houseData = houseData - (4 high diff. price value + price=0 + bed/bathrooms =0)
########################################################################
#1# CREATE new data set, remove useless columns;
## (Data.csv) Rows and columns;
print(paste("Number of records: ", nrow(data))) #4600
print(paste("Number of features: ", ncol(data))) #18
## Filter only columns used;
houseData <- data[,c("price", "bedrooms", "bathrooms",
 "sqft_living", "sqft_lot", "floors")]
## DISPLAY (houseData) Rows and columns;
print(paste("Number of records: ", nrow(houseData))) #4600
print(paste("Number of features: ", ncol(houseData))) #6
#########################################################################
#2# CLEAN the data (housedata -> new_housedata);
## IDENTIFY price range and values
range(houseData$price)
houseData[with(houseData,order(-price)),]
## REMOVE the records with substantially different prices value;
## -c(26,590,000.0 / 12,899,000.0 / 7,800.0 / 7,062,500)
houseData_sdf <- houseData[-c(4351, 4347, 4352, 2287 ), ]
## REMOVE records with features value = 0; 
new_houseData <- houseData_sdf
which(new_houseData$price == 0) # -49 rows
which(new_houseData$bedrooms == 0) # -2 rows same 
which(new_houseData$bathrooms == 0) # -2 rows same
new_houseData <-houseData_sdf[houseData_sdf$price != 0
 & houseData_sdf$bedrooms != 0
 & houseData_sdf$bathrooms != 0, ]
## DISPLAY (new_houseData) Rows and columns
print(paste("Number of records: ", nrow(new_houseData))) #4545
print(paste("Number of features: ", ncol(new_houseData))) #6
#########################################################################
#3# DISPLAY Data summary;
summary(houseData) 
summary(new_houseData)
#########################################################################
#4# GRAPH Box plot - price
boxplot(houseData$price, ylab = "Original Price", main = "House Price\n(House Data)")
boxplot(new_houseData$price, ylab = "Final Price", main = "House Price\n(New House Data)")
summary(houseData$price)
summary(new_houseData$price)
#########################################################################
#5# FIND Correlation value with price
## houseData
cor(houseData) 
cor(new_houseData) 
#########################################################################
#6# Scatter Plot - (houseData) vs price
# bathrooms
plot(houseData$bathrooms, houseData$price,
 main = "Number of Bathrooms vs House Price\n(House Data)",
 xlab = "Number of bathrooms", ylab = "House Price",
 pch = 19, frame = TRUE)
abline(lm(houseData$price ~ houseData$bathrooms, data = houseData), col = "red")
# sqft living
plot(houseData$sqft_living, houseData$price,
 main = "Sqft. Living vs House Price\n(House Data)",
 xlab = "Sqft. Living", ylab = "House Price", 
 pch = 19, frame = TRUE)
abline(lm(houseData$price ~ houseData$sqft_living, data = houseData), col = "red")
# bedrooms
plot(houseData$bedrooms, houseData$price,
 main = "Number of Bedrooms vs House Price\n(House Data)",
 xlab = "Number of Bedrooms", ylab = "House Price", 
 pch = 19, frame = TRUE)
abline(lm(houseData$price ~ houseData$bedrooms, data = houseData), col = "red")
# sqft_lot
plot(houseData$sqft_lot, houseData$price,
 main = "Sqft. Lot vs House Price\n(House Data)",
 xlab = "Sqft. Lot", ylab = "House Price", 
 pch = 19, frame = TRUE)
abline(lm(houseData$price ~ houseData$sqft_lot, data = houseData), col = "red")
# floors
plot(houseData$floors, houseData$price,
 main = "Floors vs House Price\n(House Data)",
 xlab = "Floors", ylab = "House Price", 
 pch = 19, frame = TRUE)
abline(lm(houseData$price ~ houseData$floors, data = houseData), col = "red")
#########################################################################
#7# Scatter Plot - (new_houseData) vs price
# bathrooms
plot(new_houseData$bathrooms, new_houseData$price,
 main = "Number of Bathrooms vs House Price\n(New House Data)",
 xlab = "Number of bathrooms", ylab = "House Price", 
 pch = 19, frame = TRUE)
abline(lm(new_houseData$price ~ new_houseData$bathrooms, data = new_houseData), col = "red")
# sqft living
plot(new_houseData$sqft_living, new_houseData$price,
 main = "Sqft. Living vs House Price\n(New House Data)",
 xlab = "Sqft. Living", ylab = "House Price", 
 pch = 19, frame = TRUE)
abline(lm(new_houseData$price ~ new_houseData$sqft_living, data = new_houseData), col = "red")
# bedrooms
plot(new_houseData$bedrooms, new_houseData$price,
 main = "Number of Bedrooms vs House Price\n(New House Data)",
 xlab = "Number of Bedrooms", ylab = "House Price", 
 pch = 19, frame = TRUE)
abline(lm(new_houseData$price ~ new_houseData$bedrooms, data = new_houseData), col = "red")
# sqft_lot
plot(new_houseData$sqft_lot, new_houseData$price,
 main = "Sqft. Lot vs House Price\n(New House Data)",
 xlab = "Sqft. Lot", ylab = "House Price", 
 pch = 19, frame = TRUE)
abline(lm(new_houseData$price ~ new_houseData$sqft_lot, data = new_houseData), col = "red")
# floors
plot(new_houseData$floors, new_houseData$price,
 main = "Floors vs House Price\n(New House Data)",
 xlab = "Floors", ylab = "House Price", 
 pch = 19, frame = TRUE)
abline(lm(new_houseData$price ~ new_houseData$floors, data = new_houseData), col = "red")
#########################################################################
#8# ANOVA (houseData)
#one way
options(scipen = 999)
one.way <- aov(price ~ bedrooms , data = new_houseData)
summary(one.way)
########################################################################