module UserManagement (Customer(..), readCustomerData, displayCustomers) where

import Data.List (sortOn)

data Customer = Customer {
    customerId :: Int,
    firstName :: String,
    lastName :: String,
    age :: Int,
    email :: String,
    balance :: Float,
    riskNote :: String
} deriving (Show, Read)

-- Function to read customer data from a file
readCustomerData :: FilePath -> IO [Customer]
readCustomerData filePath = do
    contents <- readFile filePath
    return (read contents :: [Customer])

-- Function to display all customers in increasing order of customerID
displayCustomers :: [Customer] -> IO ()
displayCustomers customers = mapM_ print (sortByCustomerId customers)
    where
        sortByCustomerId = sortOn customerId
