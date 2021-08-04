-- 1.1
SELECT c.CustomerID, c.CompanyName,
c.Address + ', ' + c.City + ', ' + c.PostalCode + ', ' + c.Country AS "Address"
FROM Customers c
WHERE c.City = 'Paris' OR c.City = 'London'

-- 1.2
SELECT p.ProductID, p.ProductName, p.QuantityPerUnit
FROM Products p
WHERE QuantityPerUnit LIKE '%bottle%'

-- 1.3
SELECT p.ProductID, p.ProductName, p.QuantityPerUnit, s.CompanyName, s.Country
FROM Products p
JOIN Suppliers s ON p.SupplierID = s.SupplierID
WHERE QuantityPerUnit LIKE '%bottle%'

-- 1.4
SELECT c.CategoryName,
COUNT(*) AS "Number of Products in Category"
FROM Products p
JOIN Categories c ON p.CategoryID = c.CategoryID
GROUP BY c.CategoryName
ORDER BY "Number of Products in Category" DESC

-- 1.5
SELECT e.TitleOfCourtesy + ' ' +  e.FirstName + ' ' + e.LastName AS "UK Employee Name",
e.City
FROM Employees e
WHERE e.Country = 'UK'

-- 1.6
SELECT r.RegionDescription,
ROUND(SUM((od.UnitPrice*od.Quantity)*(1-od.Discount)), 2) AS "Total Sales"
FROM Region r
JOIN Territories t ON t.RegionID = r.RegionID
JOIN EmployeeTerritories et ON et.TerritoryID = t.TerritoryID
JOIN Employees e ON e.EmployeeID = et.EmployeeID
JOIN Orders o ON o.EmployeeID = e.EmployeeID
JOIN [Order Details] od ON od.OrderID = o.OrderID
GROUP BY r.RegionDescription
HAVING SUM((od.UnitPrice*od.Quantity)*1-od.Discount) > 1000000

-- 1.7
SELECT COUNT(*)
FROM Orders
WHERE (Freight > 100 AND (ShipCountry = 'USA' OR ShipCountry = 'UK'))

-- 1.8
SELECT TOP 1 od.OrderID,
SUM((od.UnitPrice*od.Quantity)*od.Discount) AS "Discount Value"
FROM [Order Details] od
GROUP BY od.OrderID
ORDER BY"Discount Value" DESC

-- Q2
CREATE DATABASE joe_db
USE joe_db

-- 2.1
CREATE TABLE spartans(
title VARCHAR(5),
firstName VARCHAR(15),
lastName VARCHAR(15),
university VARCHAR(30),
courseName VARCHAR (30),
mark INT)

-- 2.2
INSERT INTO spartans
VALUES ("Mr.", "Joe", "Hilton", "Brunel University", "BSc Computer Science", 70)

INSERT INTO spartans (title, firstName, lastName, university, courseName, mark)
VALUES ("Mr.", "Mac", "Uche", "Essex University", "BSc Engineering", 75)

-- 3.1
SELECT e.FirstName + ' ' + e.LastName AS "Employee Name",
(SELECT s.FirstName + ' ' + s.LastName
FROM Employees s
WHERE s.EmployeeID = e.ReportsTo) AS "Reports to"
FROM Employees e

-- 3.2
SELECT s.CompanyName,
SUM((od.UnitPrice * od.Quantity)*(1-od.Discount)) AS "Total Sales"
FROM Suppliers s
JOIN Products p ON p.SupplierID = s.SupplierID
JOIN [Order Details] od ON od.ProductID = p.ProductID
GROUP BY s.CompanyName
HAVING SUM((od.UnitPrice * od.Quantity)*(1-od.Discount)) > 10000
ORDER BY "Total Sales" DESC

-- 3.3
-- Lastest year is 1998
SELECT TOP 10 c.CompanyName,
SUM((od.UnitPrice * od.Quantity)*(1-od.Discount)) AS "Total Sales"
FROM [Order Details] od
JOIN Orders o ON o.OrderID = od.OrderID
JOIN Customers c ON c.CustomerID = o.CustomerID
WHERE o.OrderDate >= '1998-01-01'
GROUP BY c.CompanyName
ORDER BY "Total Sales" DESC

-- 3.4
SELECT LEFT(CONVERT(VARCHAR(10), o.OrderDate, 111), 7) AS "Year/Month",
AVG(DATEDIFF(day, o.OrderDate, o.ShippedDate)) AS "Average Ship Time"
FROM Orders o
WHERE o.ShippedDate IS NOT NULL
GROUP BY LEFT(CONVERT(VARCHAR(10), o.OrderDate, 111), 7)
ORDER BY LEFT(CONVERT(VARCHAR(10), o.OrderDate, 111), 7)