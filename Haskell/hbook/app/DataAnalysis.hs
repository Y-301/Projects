module DataAnalysis (
    averageAge,
    averageBalance,
    averageRiskFloat,
    averageRiskValue,
    topBalancedCustomers
) where

import UserManagement
import Data.List (sortOn)

-- Requirement 3: Calculate the average age of customers
averageAge :: [Customer] -> Float
averageAge customers = fromIntegral (sumAges customers) / fromIntegral (length customers)
    where
        sumAges = sum . map age

-- Requirement 4: Calculate the average balance of customers
averageBalance :: [Customer] -> Float
averageBalance customers = totalBalance / fromIntegral (length customers)
    where
        totalBalance = sum $ map balance customers

-- Requirement 5: Calculate the average risk in float
averageRiskFloat :: [Customer] -> Float
averageRiskFloat customers = totalRisk / fromIntegral (length customers)
    where
        riskToFloat :: String -> Float
        riskToFloat "High"   = 3.0
        riskToFloat "Medium" = 2.0
        riskToFloat "Low"    = 1.0
        riskToFloat _         = 0.0 -- Default case
        totalRisk = sum $ map (riskToFloat . riskNote) customers

-- Requirement 6: Calculate the average risk in Risk Value
averageRiskValue :: [Customer] -> String
averageRiskValue customers
    | avgRisk <= 1.0 = "Low"
    | avgRisk <= 2.0 = "Medium"
    | otherwise      = "High"
    where
        avgRisk = averageRiskFloat customers

-- Requirement 7: Display the top balanced customers
topBalancedCustomers :: Int -> [Customer] -> [Customer]
topBalancedCustomers n customers = take n $ sortByBalance customers
    where
        sortByBalance = sortOn (negate . balance) -- Sorting in descending order
