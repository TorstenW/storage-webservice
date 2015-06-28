INSERT INTO users(name, email, password_hash, activated, suspended, created, updated)
VALUES ('Tester', 'test@test.com', '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', TRUE, FALSE, current_timestamp, current_timestamp);

INSERT INTO files(name, path, owner_id)
VALUES ('testfile', '/path/test/testfile.xml', 1);