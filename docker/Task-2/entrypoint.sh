#!/bin/bash
Container_Name="${CONTAINER_NAME:-unknown}"
Container_IP="$(hostname -i)"
Date="($date)"

cat <<EOF > /usr/share/nginx/html/index.html
<!DOCTYPE html>
<html>
<head>
    <title>Docker Container Details</title>
</head>
<body>

    <h1>Docker Container Details</h1>

    <p>Container Name: $Container_Name</p>
    <p>Container IP: $Container_IP</p>
    <p>Date: $Date</p>

</body>
</html>
EOF

exec nginx -g 'daemon off;'