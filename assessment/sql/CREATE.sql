USE [TESTDB]
GO

/****** Object:  Table [dbo].[staff]    Script Date: 9/17/2024 10:45:03 AM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[staff](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NULL,
	[department] [varchar](50) NULL,
	[job_grade] [varchar](50) NULL
) ON [PRIMARY]
GO


