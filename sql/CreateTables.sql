-- test_cases
CREATE 
    TABLE test_cases 
    ( 
        test_id varchar(25) NOT NULL, 
        project varchar(15) NOT NULL,
	component varchar(50) NOT NULL,
        category varchar(150) NOT NULL, 
        name varchar(250) NOT NULL, 
        notes text NOT NULL,
	deleted tinyint(1) DEFAULT '0' NOT NULL,
        PRIMARY KEY USING BTREE (test_id) 
    ) 
    ENGINE= InnoDB DEFAULT CHARSET= latin1;

-- assignments
CREATE 
    TABLE assignments 
    ( 
        id int(11) NOT NULL AUTO_INCREMENT, 
        test_id varchar(25) NOT NULL, 
        assignment varchar(50) NOT NULL, 
        timestamp datetime NOT NULL, 
        PRIMARY KEY USING BTREE (id), 
        FOREIGN KEY (test_id) REFERENCES test_cases (test_id) 
    ) 
    ENGINE= InnoDB DEFAULT CHARSET= latin1;

-- methods
CREATE 
    TABLE methods 
    ( 
        id int(11) NOT NULL AUTO_INCREMENT, 
        test_id varchar(25) NOT NULL, 
        method varchar(250), 
        PRIMARY KEY USING BTREE (id), 
        FOREIGN KEY (test_id) REFERENCES test_cases (test_id), 
        INDEX test_id USING BTREE (test_id) 
    ) 
    ENGINE= InnoDB DEFAULT CHARSET= latin1;

-- priorities
CREATE 
    TABLE priorities 
    ( 
        id int(11) NOT NULL AUTO_INCREMENT, 
        test_id varchar(25) NOT NULL, 
        priority varchar(15) NOT NULL, 
        timestamp datetime NOT NULL, 
        PRIMARY KEY USING BTREE (id), 
        FOREIGN KEY (test_id) REFERENCES test_cases (test_id) 
    ) 
    ENGINE= InnoDB DEFAULT CHARSET= latin1;

-- results
CREATE 
    TABLE results 
    ( 
        id int(11) NOT NULL AUTO_INCREMENT, 
        test_id varchar(25) NOT NULL, 
        method varchar(150), 
        result varchar(50) NOT NULL, 
        timestamp datetime NOT NULL, 
	type varchar(15) NOT NULL,
        build varchar(50), 
        suite varchar(50), 
	project varchar(15) NOT NULL,
        PRIMARY KEY USING BTREE (id), 
        FOREIGN KEY (test_id) REFERENCES test_cases (test_id) 
    ) 
    ENGINE= InnoDB DEFAULT CHARSET= latin1;

-- statuses
CREATE 
    TABLE statuses 
    ( 
        id int(11) NOT NULL AUTO_INCREMENT, 
        test_id varchar(25) NOT NULL, 
        status varchar(50) NOT NULL, 
        timestamp datetime NOT NULL, 
        PRIMARY KEY USING BTREE (id), 
        FOREIGN KEY (test_id) REFERENCES test_cases (test_id) 
    ) 
    ENGINE= InnoDB DEFAULT CHARSET= latin1;

-- users
CREATE 
    TABLE users 
    ( 
        id int(11) NOT NULL AUTO_INCREMENT, 
        name varchar(25) NOT NULL, 
        project varchar(25) NOT NULL, 
        PRIMARY KEY USING BTREE (id) 
    ) 
    ENGINE= InnoDB DEFAULT CHARSET= latin1
