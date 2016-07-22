# SENG426ECheque

## Setup Instructions
1. Download Eclipse
2. Install MySQL by following Tutorial-1.pdf
3. Continue following tutorial to create the db and tables
4. Open Eclipse
5. Set workspace to root of project folder
6. Go “File”, “Import” -> Select “General” and then “Existing Projects into Workspace”
7. Select root directory as root directory folder (should be able to see both the client and server (bank) projects)
8. Hit finish
9. Now to fix the build paths:
10. Right click client project folder -> Build path -> Configure build path
11. Select “Java build path” on the left, and then find the libraries tab (top middle)
12. Update (edit button on right) swing-layout to match your filesystem (it’s in the root of the project folder).
13. Update (edit button on right) jre7 to point to your java 7 folder (Download Java SE Runtime Environment 7 if you don’t have it). Mine installed to c:/Program Files/Java/jre7
14. Repeat with server project folder
15. Try running both the Client and Server as Java Applications to make sure they work
