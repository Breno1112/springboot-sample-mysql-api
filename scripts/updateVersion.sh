updateVersion() {
    export OLD_VERSION=$VERSION
    export NEW_VERSION=$(echo $VERSION | awk -F. -v OFS=. 'NF==1{print ++$NF}; NF>1{if(length($NF+1)>length($NF))$(NF-1)++; $NF=sprintf("%0*d", length($NF), ($NF+1)%(10^length($NF))); print}')
    sed -i "s/VERSION=$OLD_VERSION/VERSION=$NEW_VERSION/" ../deploy/deploy.conf
    cat ../deploy/deploy.conf
}
