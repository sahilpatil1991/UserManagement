echo "test";
sudo systemctl stop tomcat;
rm -rf /opt/apache-tomcat/webapps/ROOT;
rm -rf /opt/apache-tomcat/work/Catalina;
mv /home/appuser/_jenkins_work/enkin-0.0.1.war /opt/apache-tomcat/webapps/ROOT.war;
sudo systemctl start tomcat;
echo "success"