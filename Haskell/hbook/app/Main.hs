{-

It is recommended to use intellij idea for Haskell

In order to make the code work you will need to type the following in terminal:
cd C:\Users\amamr\hbook\app -- to set the location of your files
stack build -- this is used to compile the project
stack ghci -- to start GHCi
:l app/Main.hs -- loads the Main.hs file into GHCi for evaluation 
main -- to run the Main.hs file

-}

module Main (
    main
    , module UserManagement
    , module DataAnalysis
    , module RiskManagement
) where

import UserManagement
import DataAnalysis
import RiskManagement

main :: IO ()
main = do
    putStrLn "Choose an option:"
    putStrLn "1. List all the customers"
    putStrLn ">>>>>> Customer Data Analysis"
    putStrLn "2.1 Customer average age"
    putStrLn "2.2 Customer average balance"
    putStrLn "2.3 Customer average risk in float"
    putStrLn "2.4 Customer average risk in enum"
    putStrLn "2.5 List top n customer balance"
    putStrLn ">>>>>> Risk Analysis"
    putStrLn "3. List High Risk Customers"
    putStrLn "4. Exit"
    putStrLn ""
    putStr "Please enter your choice: "
    option <- getLine
    case option of
        "1" -> do
            customers <- readCustomerData "C:\\Users\\amamr\\hbook\\app\\CustomerData.txt"
            displayCustomers customers
        "2.1" -> do
            customers <- readCustomerData "C:\\Users\\amamr\\hbook\\app\\CustomerData.txt"
            let avgAge = averageAge customers
            putStrLn $ "Average age of customers: " ++ show avgAge
        "2.2" -> do
            customers <- readCustomerData "C:\\Users\\amamr\\hbook\\app\\CustomerData.txt"
            let avgBalance = averageBalance customers
            putStrLn $ "Average balance of customers: " ++ show avgBalance
        "2.3" -> do
            customers <- readCustomerData "C:\\Users\\amamr\\hbook\\app\\CustomerData.txt"
            let avgRiskFloat = averageRiskFloat customers
            putStrLn $ "Average risk of customers (Float): " ++ show avgRiskFloat
        "2.4" -> do
            customers <- readCustomerData "C:\\Users\\amamr\\hbook\\app\\CustomerData.txt"
            let avgRiskValue = averageRiskValue customers
            putStrLn $ "Average risk of customers (Value): " ++ avgRiskValue
        "2.5" -> do
            putStr "Enter number of top customers: "
            n <- getLine
            customers <- readCustomerData "C:\\Users\\amamr\\hbook\\app\\CustomerData.txt"
            let topCustomers = topBalancedCustomers (read n) customers
            putStrLn "Top Balanced Customers:"
            displayCustomers topCustomers
        "3" -> do
            putStr "Enter threshold balance: "
            threshold <- getLine
            customers <- readCustomerData "C:\\Users\\amamr\\hbook\\app\\CustomerData.txt"
            let highRisk = highRiskCustomers (read threshold) customers
            putStrLn "High Risk Customers:"
            displayCustomers highRisk
        "4" -> putStrLn "Exiting the program..."
        _ -> putStrLn "Invalid option!"
