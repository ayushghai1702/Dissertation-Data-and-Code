install.packages("seriation")
install.packages("factoextra")
library(factoextra)
library(clustertend)
library(seriation)
library(ggplot2)
data<-read.csv("Scratch.csv")
df<- data.frame(data$stview)
df
nrow(df)
#hopkins(data,n=1044,byrow = TRUE,header = TRUE)
df_scaled <- scale(df)
df_dist <- dist(df_scaled) 
dissplot(df_dist)
clustend <- get_clust_tendency(scale(df), 1044)
clustend$hopkins_stat
aclustend$plot + 
  scale_fill_gradient(low = "steelblue", high = "white")

df#test
x<-matrix(runif(200,1,100),50,4);
hopkins(x,n=10,header = TRUE)
res <- cor(data)
my_data<- data[,c(8,9,10,11)]
my_data
res<-cor(my_data)
res
