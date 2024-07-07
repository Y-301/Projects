module RiskManagement (highRiskCustomers) where

import UserManagement

-- Requirement 8: Displaying high risky customers
highRiskCustomers :: Float -> [Customer] -> [Customer]
highRiskCustomers threshold = filter isHighRisk
    where
        isHighRisk :: Customer -> Bool
        isHighRisk customer = riskNote customer == "High" && balance customer < threshold
