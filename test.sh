echo "http://127.0.0.1:8080/racks"
curl --url http://127.0.0.1:8080/racks
echo ""
echo "Get all the available racks"
echo "" 
echo "http://127.0.0.1:8080/rack/001"
curl --url http://127.0.0.1:8080/rack/001
echo ""
echo "Get the entire rack 001 object"
echo "" 
echo "http://127.0.0.1:8080/rack/001/remaining"
curl --url http://127.0.0.1:8080/rack/001/remaining
echo ""
echo "Get the number of remaining slots on rack 001"
echo "" 
echo "http://127.0.0.1:8080/rack/001/name"
curl --url http://127.0.0.1:8080/rack/001/name
echo ""
echo "Get the name of rack 001"
echo "" 
echo "http://127.0.0.1:8080/rack/55"
curl --url http://127.0.0.1:8080/rack/55
echo ""
echo "Try to get a rack that isn't actually available"
echo "" 
echo "http://127.0.0.1:8080/server/123453"
curl --url http://127.0.0.1:8080/server/12453
echo ""
echo "This is an example of the API working to get a server's entire object"
echo ""
echo "http://127.0.0.1:8080/server/123453/name"
curl --url http://127.0.0.1:8080/server/12453/name
echo
echo "This is an example getting the servers name"
echo
