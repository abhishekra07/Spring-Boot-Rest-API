DROP TABLE IF EXISTS apierrors;
 
CREATE TABLE apierrors (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  code VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL
);
 
INSERT INTO apierrors (code, description) VALUES
  ('INFO001', 'Invalid First Name'),
  ('INFO002', 'Invalid Middle Name'),
  ('INFO003', 'Invalid Last Name'),
  ('INFO004', 'Invalid Email Address'),
  ('INFO005', 'Invalid Age'),
  ('INFO006', 'Invalid Gender'),
  ('INFO007', 'Invalid language'),
  ('INFO008', 'Invalid date of birth'),
  ('ADDR001', 'Invalid Address Type'),
  ('ADDR002', 'Invalid Address Line 1'),
  ('ADDR003', 'Invalid City'),
  ('ADDR004', 'Invalid State'),
  ('ADDR005', 'Invalid Zip Code'),
  ('PHN001', 'Invalid Phone Type'),
  ('PHN002', 'Invalid Phone Number'),
  ('JSON001', 'Invalid JSON Format'),
  ('GENR001', 'User Not Found'),
  ('GENR002', 'Insert Failed');